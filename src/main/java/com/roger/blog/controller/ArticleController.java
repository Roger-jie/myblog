package com.roger.blog.controller;

import com.roger.blog.config.WebSecurityConfig;
import com.roger.blog.dao.ArticleMapper;
import com.roger.blog.dao.ArticleTagMapper;
import com.roger.blog.dao.TagMapper;
import com.roger.blog.model.*;
import com.roger.blog.model.json.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    ArticleTagMapper articleTagMapper;
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

    @RequestMapping(value = "/adminGetArticleList",method = RequestMethod.GET)
    @ResponseBody
    public PageList getAdminArticleList(Article article,Page page){
        List<Article> articleList = articleMapper.getArticleListByLimt(article,page);
        int count = articleMapper.getArticleCount();
        PageList pageList = new PageList(count,articleList);
        return pageList;
    }

    @RequestMapping(value = "/adminAddArticle")
    @ResponseBody
    public AjaxJson adminAddArticle(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user,Article article, HttpServletRequest request){
        AjaxJson json = new AjaxJson();
       // System.out.println(article.getTag());
        try {
            article.setAuthor(user.getId());
            articleMapper.addArticle(article);
            saveArticleTag(article);
            json.setSuccess(true);
            json.setMsg("文章保存成功");
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg("文章保存失败");
        }
        return json;
    }

    private void saveArticleTag(Article article) {
        List<String> formList = article.getTag();
        List<Tag> tagList = tagMapper.getAllTag();
        for (Tag tag : tagList) {
            if (!formList.contains(tag.getName())) {
                tagMapper.saveTag(tag);
            }
            articleTagMapper.saveArticleTag(article.getId(),tag.getId());
        }
    }

    @RequestMapping(value = "/adminArticleUpdate")
    public String adminArticleUpdate(String id,Model model){
        Article article = articleMapper.getArticleByID(id);
        model.addAttribute("article", article);
        return "admin/admin_articleUpdate";
    }

    @RequestMapping(value = "/adminUpdateArticle")
    @ResponseBody
    public AjaxJson adminUpdateArticle(Article article,HttpServletRequest request){
        AjaxJson ajaxJson = new AjaxJson();
        try {
            articleMapper.updateArticle(article);
            ajaxJson.setSuccess(true);
            ajaxJson.setMsg("文章修改成功");
        } catch (Exception e) {
            ajaxJson.setSuccess(false);
            ajaxJson.setMsg("文章修改失败");
        }
        return ajaxJson;
    }

    @RequestMapping("/articleDetail")
    public String articleDetail(String id,Model model){
        Article article = articleMapper.getArticleByID(id);
        model.addAttribute("article",article);
        return "article/article";
    }

    @RequestMapping("/adminDelArticle")
    @ResponseBody
    public AjaxJson adminDelArticle(String id){
        AjaxJson json = new AjaxJson();
        try {
            articleMapper.deleteArticle(id);
            json.setSuccess(true);
            json.setMsg("文章删除成功");
        } catch (Exception e) {
            json.setSuccess(false);
            json.setMsg("文章删除失败");
        }
        return json;
    }

}
