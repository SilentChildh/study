package com.pojo.dto.user;


import com.pojo.dto.BasicDTO;

import java.util.Objects;
/**
 * 用于传输用户部分可展示信息
 * @author silent_child
 * @version 1.0
 **/

public class UserDTO implements BasicDTO {
    private Long id;
    private String name;
    private String email;
    private Integer privilege;

    public UserDTO() {
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
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(privilege, userDTO.privilege);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, privilege);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", privilege=" + privilege +
                '}';
    }
}
