package com.pojo.vo.user;

import com.view.Transformation;

import java.util.Objects;
/**
 * 接收转换器包装后的信息。
 * @see Transformation#getUserVO()
 * @author silent_child
 * @version 1.0
 **/

public class UserVO {
    private Long id;
    private String name;
    private String email;
    private Integer privilege;

    public UserVO() {
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
        UserVO userVO = (UserVO) o;
        return Objects.equals(id, userVO.id) && Objects.equals(name, userVO.name) && Objects.equals(email, userVO.email) && Objects.equals(privilege, userVO.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, privilege);
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
