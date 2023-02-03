package com.pojo.bo.user;

/**
 * 用于完成用户登录的单位
 * @author silent_child
 * @version 1.0
 **/

public class UserLoginBO {
    private String name;
    private String password;

    public UserLoginBO() {
    }

    public UserLoginBO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
