package com.roger.blog.model;

/**
 *  标签表
 *  @author  Roger
 *  2017.12.14
 */
public class Tag {

    private int id;

    private String name;

    private String count;

    public Tag() {
    }

    public Tag(int id, String name, String count) {
        this.id = id;
        this.name = name;
        this.count = count;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
