package com.roger.blog.model;

/**
 *  分类表
 *  @author  Roger
 *  2017.12.14
 */
public class Catalog {

    private int id;

    private String name;

    private String remark;

    public Catalog() {
    }

    public Catalog(int id, String name, String remark) {
        this.id = id;
        this.name = name;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
