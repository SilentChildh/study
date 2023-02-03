package com.dao.util;

import com.dao.sqlparse.SAXParserSQLHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 现含三种功能：1. 连接数据库；2. 关闭相关数据资源；3. 解析xml文件得到sql语句
 * @author silent_child
 * @version 1.0
 **/

public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static final String mySQLPropertiesPath = "E:\\Git\\3122004572-huanghehua\\任务\\第二阶段任务\\src\\mysql.properties";

    //用于从配置文件中加载信息
    static {
        Properties p = new Properties();

        try {
            p.load(new FileInputStream(mySQLPropertiesPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        url = p.getProperty("url");
        user = p.getProperty("user");
        password = p.getProperty("password");
    }

    /**
     * 用于连接数据库
     * @return Connection {@link Connection} 返回的是统一的数据库连接接口
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 用于关闭资源
     * @param res 已开启的ResultSet 或者是 null
     * @param statement 已开启的Statement 或者是 null
     * @param connection 已开启的Connection 或者是 null
     */
    public static void close(ResultSet res, Statement statement, Connection connection) {
        try {
            if(res != null) {
                res.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    private static SAXParser saxParser;
    private static SAXParserSQLHandler sqlHandler;

    static {
        // 用于得到SAXParser实例
        try {
            saxParser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
        // 用于得到SAXParserSQLHandler实例
        sqlHandler = new SAXParserSQLHandler();
    }

    /**
     * 用于解析xml中的sql语句，并返回对应类型的字符串
     * @param xml 内部含sql语句的依赖文件
     * @param SQLType 传入静态内部类{@link SQLType}中的标准参数
     * @return String 四种类型的sql语句字符串
     */
    public static String parse(FileInputStream xml, Integer SQLType) {
        try {
            saxParser.parse(xml, sqlHandler);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        //若成功返回对应的sql语句
        if (SQLType.equals(JdbcUtils.SQLType.SELECT)) return sqlHandler.getSelect();
        else if (SQLType.equals(JdbcUtils.SQLType.INSERT)) return sqlHandler.getInsert();
        else if (SQLType.equals(JdbcUtils.SQLType.UPDATE)) return sqlHandler.getUpdate();
        else if (SQLType.equals(JdbcUtils.SQLType.DELETE)) return sqlHandler.getDelete();

        //以往万一 返回null
        return null;
    }


    /**
     * 制定SQL语句的类型等级。向外开放.<br/>
     * 调用者在调用{@link JdbcUtils#parse(FileInputStream, Integer)}时，
     * 传入的参数应以该静态内部类为准以便符合标准。
     * @author silent_child
     * @version 1.0
     **/

    public static class SQLType {
        public static final Integer SELECT = 0;
        public static final Integer INSERT = 1;
        public static final Integer UPDATE = 2;
        public static final Integer DELETE = 3;
    }
}
