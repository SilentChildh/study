package com.view;

import java.util.Objects;
/**
 * 接收转换器包装后的信息。
 * @see Transformation#getUserVO(String, String)
 * @author silent_child
 * @version 1.0
 **/

public class UserVO {
    private String name;
    private String email;
    private Integer privilege;

    public UserVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        UserVO vo = (UserVO) o;
        return privilege == vo.privilege && Objects.equals(name, vo.name) && Objects.equals(email, vo.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, privilege);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
