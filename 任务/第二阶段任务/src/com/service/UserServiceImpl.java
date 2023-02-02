package com.service;

import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserPrivilege1BO;
import com.pojo.bo.user.UserPrivilege2BO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;

public class UserServiceImpl implements UserService{

    @Override
    public boolean login(UserLoginBO bo) {
        return false;
    }

    @Override
    public boolean register(UserRegisterBO bo) {
        return false;
    }

    @Override
    public UserDTO query(Long id) {
        return null;
    }

    @Override
    public void privilege1(UserPrivilege1BO bo) {

    }

    @Override
    public void privilege2(UserPrivilege2BO bo) {

    }
}
