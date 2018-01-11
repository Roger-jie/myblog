package com.roger.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@SpringBootApplication()
@ServletComponentScan //配置druid必须加的注解，如果不加，访问页面打不开，filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
public class Start extends SpringBootServletInitializer {
    // Tomcat需要主类有一个无参构造器
    public Start() {
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Start.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }
}
