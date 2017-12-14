package com.roger.blog.model;

import java.util.Date;

/**
 *  评论表实体
 *  @author  Roger
 *  2017.12.14
 */
public class Comment {

    private int id;
    //评论内容
    private String content;
    //评论者昵称
    private String user_name;
    //文章ID
    private String article_id;
    //创建时间
    private Date create_date;
    //评论状态
    private String status;
    //评论者地址
    private String user_url;
    //评论者邮箱
    private String user_email;

    public Comment() {
    }

    public Comment(int id, String content, String user_name, String article_id, Date create_date, String status, String user_url, String user_email) {
        this.id = id;
        this.content = content;
        this.user_name = user_name;
        this.article_id = article_id;
        this.create_date = create_date;
        this.status = status;
        this.user_url = user_url;
        this.user_email = user_email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_url() {
        return user_url;
    }

    public void setUser_url(String user_url) {
        this.user_url = user_url;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
