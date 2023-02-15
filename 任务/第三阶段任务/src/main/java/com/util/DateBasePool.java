package com.util;

import com.exception.MinIdledException;
import com.exception.OverMaxActiveException;
import com.exception.TimedOutException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
/**
 * 数据库连接池
 * @author silent_child
 * @version 1.0
 **/

public class DateBasePool {
    private static Logger logger = MyLogger.getLogger();
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("dataBasePool-config");
    private static String driver = resourceBundle.getString("driver");
    private static String url = resourceBundle.getString("url");
    private static String user = resourceBundle.getString("username");
    private static String pwd = resourceBundle.getString("password");
    /**
     * 初始化连接数
     */
    private static int initialSize = Integer.parseInt(resourceBundle.getString("initialSize"));
    /**
     * 空闲池中最少的连接资源数量
     */
    private static int minIdle = Integer.parseInt(resourceBundle.getString("minIdle"));
    /**
     * 活跃状态下的最大连接数
     */
    private static int maxActive = Integer.parseInt(resourceBundle.getString("maxActive"));
    /**
     * 最大连接时长
     */
    private static int maxWait = Integer.parseInt(resourceBundle.getString("maxWait"));
    /**
     * 使用并发队列，线程安全，而且是队列数据结构，更符合池化技术
     */
    private static ConcurrentLinkedQueue<Connection> queue = new ConcurrentLinkedQueue<>();
    /**
     * 目前处于活跃状态的连接资源数量
     */
    private static int presentMaxActive;

    /**
     * 记录获取资源释放是否超时
     */
    private static boolean isTimedOut;

    static {
        try {
            // 注册数据库驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 获取初始化资源
        for (int i = 0; i < initialSize; i++) {
            queue.add(getProxyConnection());
        }

        logger.info("数据库连接池初始化完毕");

        /*开启线程，监控空闲池中最少连接数量
        * 为保证资源充足，当空闲池为资源数量5时，便开始增加资源，且一次增加两个
        * 此处的相关数据也许可以写到配置文件中
        * */
        Thread listener = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.interrupted()) {
                    if (queue.size() <= minIdle) {
                        for (int i = 0; i < 2; i++) {
                            queue.add(getProxyConnection());
                        }
                    }
                }
            }
        },"监控最少空闲连接数");
        listener.setDaemon(true);
        listener.start();
    }


    /**
     * 用于从空闲池中获取连接资源
     * @return {@link Connection}
     */
    public static Connection getConnection() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                // 不会出现阻塞情况，故不需要捕获InterruptedException
                while (!Thread.interrupted()) {
                    if ((System.currentTimeMillis() - start) > maxWait) {
                        isTimedOut = true;
                    }
                }
            }
        });
        // 开启计时器
        thread.start();

        while (true) {
            synchronized (queue) {
                /*// 模拟超时
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/

                try {
                    // 超过最大活跃数、低于最小空闲数、获取超时 则返回null
                    isOverMaxActive();

                    // isMinIdled();
                    // 不使用额外的方法，而是让线程睡眠一会来缓冲
                    Thread.sleep(20);

                    isTimedOut();

                    // 通过检验，则返回一个连接资源，并令活跃连接数量自增
                    presentMaxActive++;
                    return queue.poll();

                }
                // 以下代码也可以继续向上抛出，直到抛给controller层来调度view层展示信息
                /*如：
                * catch (RuntimeException e) {
                    // 记录日志
                    logger.info("连接失败:" + e.getMessage());
                    throw e;
                }
                * */
                catch (OverMaxActiveException e) {
                    // 记录日志
                    logger.info("连接失败:" + e.getMessage());
                    // 展示给用户看
                    System.out.println("连接失败,请重试...");
                    // 并返回null
                    return null;
                } catch (MinIdledException e) {
                    logger.info("连接失败:" + e.getMessage());
                    System.out.println("连接失败,请重试...");
                    return null;

                } catch (TimedOutException e) {
                    logger.info("连接失败:" + e.getMessage());
                    System.out.println("连接失败,请重试...");
                    return null;
                } catch (InterruptedException e) {
                    logger.info("睡眠中断" + e.getMessage());

                } finally {
                    // 该方法返回时中断线程
                    thread.interrupt();
                    // 重置超时标记
                    isTimedOut = false;
                }
            }
        }
    }

    private static Connection getProxyConnection() {
        return (Connection) Proxy.newProxyInstance(Connection.class.getClassLoader(), new Class[] {Connection.class},
                new InvocationHandler() {
                    private Connection connection;
                    {
                        try {
                            connection = DriverManager.getConnection(url, user, pwd);
                        } catch (SQLException e) {
                            throw new RuntimeException("连接资源入池失败");
                        }
                    }

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 如果调用的是close方法，则调用自定义数据库连接池的reclaim方法
                        if ("close".equals(method.getName())) {
                            return reclaim(connection);
                        }
                        // 如果是其他方法则无所谓了
                        return method.invoke(connection, args);
                    }
                });

    }
    /**
     * 用于回收资源到空闲池
     * @param connection 需要回收的连接资源
     */
    private static Void reclaim(Connection connection) {
        queue.add(getProxyConnection());
        presentMaxActive--;// 当前活跃数量自减
        return null;
    }

    /**
     * 用于判断是否低于{@link DateBasePool#minIdle}
     */
    private static Void isMinIdled() {
        if (queue.size() <= minIdle) {
            throw new MinIdledException("已达最小空闲连接数量");
        }
        return null;
    }

    /**
     * 用户判断是否大于{@link DateBasePool#maxActive}
     */
    private static Void isOverMaxActive() {
        if (presentMaxActive >= maxActive) {
            throw new OverMaxActiveException("连接数量已达阈值");
        }
        return null;
    }

    /**
     * 用户判断是否连接超时{@link DateBasePool#isTimedOut}
     */
    private static Void isTimedOut() {
        if (isTimedOut) {
            throw new TimedOutException("连接超时");
        }
        return null;
    }

}
