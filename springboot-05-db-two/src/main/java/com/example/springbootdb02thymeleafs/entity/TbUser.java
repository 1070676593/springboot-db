package com.example.springbootdb02thymeleafs.entity;

import lombok.Data;

import java.util.Date;

/**
 * @CalssName: TbUser
 * @Author: zsx
 * @Date: 2020/4/7 15:36
 **/
@Data
public class TbUser {
    private int id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String created;
    private Date updated;

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created='" + created + '\'' +
                ", updated=" + updated +
                '}';
    }
}
