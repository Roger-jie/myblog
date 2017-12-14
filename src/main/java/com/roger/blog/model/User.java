package com.roger.blog.model;

/**
 *  用户实体表
 *  @author  Roger
 *   2017.12.14
 */
public class User {
    private int id;
    //登录名
    private String login_name;
    //昵称
    private String name;
    private String password;
    //头像
    private String headUrl;
    private String email;
    //简介
    private String brief;


    public User(){

    }

    public User(int id, String login_name, String name, String password, String headUrl, String email, String brief) {
        this.id = id;
        this.login_name = login_name;
        this.name = name;
        this.password = password;
        this.headUrl = headUrl;
        this.email = email;
        this.brief = brief;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

}
