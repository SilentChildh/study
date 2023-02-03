package com.service;

import com.pojo.bo.user.UserLoginBO;
import com.pojo.bo.user.UserPrivilege1BO;
import com.pojo.bo.user.UserPrivilege2BO;
import com.pojo.bo.user.UserRegisterBO;
import com.pojo.dto.user.UserDTO;

import java.io.FileInputStream;

/**
 * 用户相关业务接口
 * @author silent_child
 * @version 1.0
 **/

public interface UserService {

    /**
     * 用户登录
     * @param bo 登录业务单位
     * @return boolean 返回登陆结果
     */
    boolean login(UserLoginBO bo);

    /**
     * 用户注册
     * @param bo 注册业务单位
     * @return boolean 返回注册结果
     */
    boolean register(UserRegisterBO bo);

    /**
     * 查询指定用户信息
     * @param id 在数据库中为主键且自增长的bigInt字段
     * @return 返回DTO实例，内含指定用户可展示的信息
     */
    UserDTO query(Long id);

    //Integer update();

    /**
     * 特权功能1
     * @param bo 特权业务单位
     */
    void privilege1(UserPrivilege1BO bo);

    /**
     * 特权功能2
     * @param bo 特权业务单位
     */
    void privilege2(UserPrivilege2BO bo);
}
