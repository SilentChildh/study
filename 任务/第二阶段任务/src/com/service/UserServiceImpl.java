package com.service;

import com.dao.BasicDAO;
import com.dao.DAOProxyHandler;
import com.dao.user.UserDAO;
import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserPrivilege1BO;
import com.pojo.bo.user.UserPrivilege2BO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;

import java.io.FileInputStream;

public class UserServiceImpl implements UserService{

    //在该层下统一完成用户业务，其中会涉及到对数据库的操作，故将局部变量提取为成员变量，提高复用性。
    // 获取dao的代理类
    private BasicDAO dao = new DAOProxyHandler().getDaoProxy(new UserDAO());

    private DAOProxyHandler daoProxyHandler;
    @Override
    public boolean login(UserLoginBO bo) {
        return false;
    }

    @Override
    public boolean register(UserRegisterBO bo) {
        return false;
    }

    @Override
    public UserDTO query(Long id, FileInputStream xml) {
        //动态代理
        dao.query(xml);
        return null;
    }

    @Override
    public void privilege1(UserPrivilege1BO bo) {

    }

    @Override
    public void privilege2(UserPrivilege2BO bo) {

    }
}
