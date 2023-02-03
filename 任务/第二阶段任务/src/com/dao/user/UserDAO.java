package com.dao.user;

import com.dao.BasicDAO;
import com.dao.util.JdbcUtils;
import com.pojo.dto.user.UserDTO;
import com.pojo.po.BasicPO;
import com.pojo.po.user.UserPO;

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


    @Override
    public void setXml(FileInputStream xml) {
        this.xml = xml;
    }

    @Override
    public ArrayList<UserDTO> query(UserPO po) {
        ArrayList<UserDTO> res = new ArrayList<>();
        String sql = JdbcUtils.parse(xml, JdbcUtils.SQLType.SELECT);;
        try {
            preparedStatement = connection.prepareStatement(sql);//获取statement进行操作sql语句
            resultSet = preparedStatement.executeQuery();//得到查询集合

            //循环赋值，然后放到集合中
            while (resultSet.next()) {
                UserDTO dto = new UserDTO();
                dto.setId(resultSet.getInt("id"));
                dto.setName(resultSet.getString("name"));
                dto.setName(resultSet.getString("email"));
                dto.setName(resultSet.getString("privilege"));
                res.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return res;
    }

    @Override
    public UserDTO querySingleLine(BasicPO po) {
        UserDTO dto = new UserDTO();
        String sql = JdbcUtils.parse(xml, JdbcUtils.SQLType.SELECT);
        try {
            preparedStatement = connection.prepareStatement(sql);//获取statement进行操作sql语句
            preparedStatement.setLong(1, ((UserPO)po).getId());
            resultSet = preparedStatement.executeQuery();//得到查询集合

            //如果找得到，那么就给dto赋值。
            //如果找不到，那么也直接返回一个空的dto
            if (resultSet.next()) {
                dto.setId(resultSet.getInt("id"));
                dto.setName(resultSet.getString("name"));
                dto.setName(resultSet.getString("email"));
                dto.setName(resultSet.getString("privilege"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public String querySingleField(BasicPO po) {
        return null;
    }


    @Override
    public int update(BasicPO po) {
        int rows = 0;
        return rows;
    }
}
