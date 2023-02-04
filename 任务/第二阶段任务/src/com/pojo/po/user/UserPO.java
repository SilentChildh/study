package com.pojo.po.user;

import com.dao.BasicDAO;
import com.pojo.po.BasicPO;

import java.util.Objects;
/**
 * 持久化用户对象。<br/>
 * 可用于接收数据库中用户表的信息，然后后向服务端输送。<br/>
 * 也可用于接收服务端想持久化的对象信息，然后向数据库输送。
 * @author silent_child
 * @version 1.0
 **/

public  class UserPO implements BasicPO {
    private Long id;
    private String name;
    private String password;
    private String email;
    //根据三级权限发分为普通用户、管理员和超级管理员
    private Integer privilege;

    public UserPO() {}

    /**
     * 用于设置用户的权限
     * @author silent_child
     * @version 1.0
     **/
    public static class Level {
        //无任何权限
        public static final Integer NONE = 0;
        //拥有对普通用户的管理权限
        public static final Integer Partial = 1;
        //拥有对普通管理员和普通成员的管理权限
        public static final Integer All = 2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPO userPO = (UserPO) o;
        return Objects.equals(id, userPO.id) && Objects.equals(name, userPO.name) && Objects.equals(password, userPO.password) && Objects.equals(email, userPO.email) && Objects.equals(privilege, userPO.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, email, privilege);
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
