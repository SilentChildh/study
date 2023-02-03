package com.dao.user;

import com.dao.BasicDAO;
import com.dao.util.JdbcUtils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 是顶级DAO下，针对User数据访问的DAO类。<br/>
 * 内部可含对User数据操作的特有方法。
 * @author silent_child
 * @version 1.0
 **/

public class UserDAO implements BasicDAO {
    //外部依赖xml文件，内含sql语句
    private FileInputStream xml;

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public <T> ArrayList<T> query() {
        String sql = JdbcUtils.parse(xml, JdbcUtils.SQLType.SELECT);;
        try {
            connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        ArrayList<T> res = new ArrayList<>();
        return res;
    }


    public int update() {
        int rows = 0;
        return rows;
    }
}
