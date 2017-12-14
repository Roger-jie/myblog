package com.roger.blog.model;

import java.util.Date;

/**
 *  文章表
 * @author  Roger
 *  2017.12.14
 */
public class Article {

    private int  id;
    //标题
    private String title;
    //描述
    private String describes;
    //内容
    private String content;
    //创建时间
    private Date create_date;
    //评论数量
    private String comment_count;
    //分类
    private String category;

    public Article() {}

    public Article(int id, String title, String describes, String content, Date create_date, String comment_count, String category) {
        this.id = id;
        this.title = title;
        this.describes = describes;
        this.content = content;
        this.create_date = create_date;
        this.comment_count = comment_count;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
