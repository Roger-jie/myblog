package com.roger.blog.controller;

import com.roger.blog.dao.ArticleMapper;
import com.roger.blog.model.Article;
import com.roger.blog.model.Page;
import com.roger.blog.model.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    ArticleMapper articleMapper;

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
        System.out.println("我来了");
        return "admin/admin_articleList";
    }

    @RequestMapping(value = "/adminGetArticleList",method = RequestMethod.GET)
    @ResponseBody
    public PageList getAdminArticleList(Page page){
        System.out.println("我再走"+page.getPage());
        PageList pageList = new PageList();
        Article article = new Article();
        List<Article> articleList = articleMapper.getArticleListByLimt(page);
        int count = articleMapper.getArticleCount();
        pageList.setCount(count);
        pageList.setData(articleList);
        return pageList;
    }
}
