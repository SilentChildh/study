package com.util;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;


public class DataBasePoolTest {
    @Test
    void TestGetConnection() throws InterruptedException {
        Logger logger = MyLogger.getLogger();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {
                    Connection connection = DateBasePool.getConnection();
                    logger.info("T1 线程获取第" + i + "个 " + connection);
                    if (i <= 10 && connection != null) {
                        logger.info("T1 释放第" + i + "个 " + connection);
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 30; i++) {

                    Connection connection = DateBasePool.getConnection();
                    logger.info("T2 获取第" + i + "个 " + connection);
                    if (i <= 10 && connection != null) {
                        logger.info("T2 释放第" + i + "个 " + connection);
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(5000);

    }

}
