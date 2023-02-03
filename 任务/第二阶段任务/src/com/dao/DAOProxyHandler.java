package com.dao;

import com.dao.sqlparse.SAXParserSQLHandler;
import com.dao.util.JdbcUtils;

import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理dao
 * @author silent_child
 * @version 1.0
 **/

public class DAOProxyHandler implements InvocationHandler {

    //用于接收具体的dao子类
    private BasicDAO dao;


    /**
     * 获取dao的代理类
     * @param dao 被代理的dao子类
     * @return BasicDAO 返回一个代理实例，该实例是Object，需要向下转型为BasicDAO
     */
    public BasicDAO getDaoProxy(BasicDAO dao) {
        this.dao = dao;
        Class<? extends BasicDAO> clazz = dao.getClass();
        return (BasicDAO) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }



    private void before() {
        //获取连接
        JdbcUtils.getConnection();

    }

    private void after() {
        //关闭资源
        JdbcUtils.Close();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.dao, args);
        after();
        return obj;
    }
}
