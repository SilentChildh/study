package com.dao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

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
    public static void Close(ResultSet res, Statement statement, Connection connection) {
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


}
