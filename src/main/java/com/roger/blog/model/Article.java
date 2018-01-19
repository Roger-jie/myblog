package com.roger.blog.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  文章表
 * @author  Roger
 *  2017.12.14
 */
public class Article implements Serializable{

    private Integer  id;
    //标题
    private String title;
    //描述
    private String describes;
    //关键字
    private String keyword;
    //点击量
    private Integer click;
    //内容
    private String content;
    //创建时间
    private Date create_date;
    //评论数量
    private String comment_count;
    //分类
    private String category;
    //MD值
    private String md;

    private Integer is_show;

    private Integer author;

    private String imgs;

    private Integer stick;

    private String tags;

    public Article() {}

    public Article(Integer id, String title, String describes, String keyword, Integer click, String content, Date create_date, String comment_count, String category, String md, Integer is_show, Integer author, String imgs, Integer stick, String tags) {
        this.id = id;
        this.title = title;
        this.describes = describes;
        this.keyword = keyword;
        this.click = click;
        this.content = content;
        this.create_date = create_date;
        this.comment_count = comment_count;
        this.category = category;
        this.md = md;
        this.is_show = is_show;
        this.author = author;
        this.imgs = imgs;
        this.stick = stick;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
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

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public Integer getIs_show() {
        return is_show;
    }

    public void setIs_show(Integer is_show) {
        this.is_show = is_show;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Integer getStick() {
        return stick;
    }

    public void setStick(Integer stick) {
        this.stick = stick;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", describes='" + describes + '\'' +
                ", keyword='" + keyword + '\'' +
                ", click=" + click +
                ", content='" + content + '\'' +
                ", create_date=" + create_date +
                ", comment_count='" + comment_count + '\'' +
                ", category='" + category + '\'' +
                ", md='" + md + '\'' +
                ", is_show=" + is_show +
                ", author=" + author +
                ", imgs='" + imgs + '\'' +
                ", stick=" + stick +
                ", tag=" + tags +
                '}';
    }

}
