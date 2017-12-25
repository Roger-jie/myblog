package com.roger.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

    /**
     * 文章发布页面
     * @return
     */
    @RequestMapping("/adminArticle")
    public String adminArticle(){
        return "admin/admin_article";
    }

    /**
     * 文章列表页面
     * @return
     */
    @RequestMapping("/adminArticleList")
    public String adminArticleList(){
        return "admin/admin_articleList";
    }
}
