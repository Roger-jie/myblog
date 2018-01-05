package com.roger.blog.util;

public class PageUtils {


    public static String getPageSql(String sql){
        return sql + " limit #{page.page},#{page.limit} ";
    }
}
