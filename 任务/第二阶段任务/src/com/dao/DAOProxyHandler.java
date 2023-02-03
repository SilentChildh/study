package com.dao;

import com.dao.util.JdbcUtils;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 动态代理dao
 * @author silent_child
 * @version 1.0
 **/

public class DAOProxyHandler implements InvocationHandler {

    //获得xml文件
    private FileInputStream xml;
    //用于接收具体的dao子类
    private BasicDAO dao;

    //用于接收被代理的dao的三个字段
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    //通过反射获取三个操作mySQL的字段
    private Field[] fields = this.dao.getClass().getFields();

    //以下静态常量用于反射相关校验
    private static final String QUERY = "query";
    private static final String UPDATE = "update";
    private static final String XML = "xml";
    private static final String CONNECTION = "connection";
    private static final String PREPAREDSTATEMENT = "preparedStatement";
    private static final String RESULTSET = "resultSet";

    /**
     * 获取dao的代理类
     *
     * @param dao 被代理的dao子类
     * @param xml
     * @return BasicDAO 返回一个代理实例，该实例是Object，需要向下转型为BasicDAO
     */
    public BasicDAO getDaoProxy(BasicDAO dao, FileInputStream xml) {
        this.dao = dao;
        this.xml = xml;
        Class<? extends BasicDAO> clazz = dao.getClass();
        return (BasicDAO) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }



    private void before() throws NoSuchFieldException, IllegalAccessException {

        //循环获得两个字段，并赋值
        for (Field field: fields) {
            field.setAccessible(true);
            if (field.getName().equals(XML)) {
                field.set(this.dao, xml);// 注入xml依赖
            }
            else if (field.getName().equals(CONNECTION)) {
                connection = JdbcUtils.getConnection();
                field.set(this.dao, connection);// 提供连接，以便获得PreparedStatement
            }
        }
    }

    private void after() throws IllegalAccessException {
        //循环获得两个字段
        for (Field field: fields) {
            field.setAccessible(true);
            if (field.getName().equals(PREPAREDSTATEMENT)) {
                preparedStatement = (PreparedStatement) field.get(this.dao);
            }
            else if (field.getName().equals(RESULTSET)) {
                resultSet = (ResultSet) field.get(this.dao);
            }
        }

        //最后关闭资源
        JdbcUtils.close(resultSet,preparedStatement, connection);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.dao, args);
        after();
        return obj;
    }
}
