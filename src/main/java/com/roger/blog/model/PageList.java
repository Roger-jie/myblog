package com.roger.blog.model;

import java.util.List;

/**
 * 列表分页返回实体
 * @author roger
 */
public class PageList {

    private int code = 0;

    private String msg = "";

    private Integer count;

    private List data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
