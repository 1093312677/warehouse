package com.warehouse.entity;

import java.util.Date;

/**
 * 用户信息实体类
 * Created by kone on 2017-08-06.
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private Date create_time;

    public User() {
    }

    public User(Long id, String username, String password, Date create_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.create_time = create_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
