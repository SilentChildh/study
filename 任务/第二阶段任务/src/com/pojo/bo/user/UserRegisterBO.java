package com.pojo.bo.user;

/**
 * 用于完成用户注册的单位
 * @author silent_child
 * @version 1.0
 **/

public class UserRegisterBO {
    private String name;
    private String password;
    private String email;

    public UserRegisterBO() {
    }

    public UserRegisterBO(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
