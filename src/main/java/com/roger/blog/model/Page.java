package com.roger.blog.model;

public class Page {

    private int page = 1;

    private int limit = 10;

    public int getPage() {
        return page-1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
