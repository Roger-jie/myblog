package com.roger.blog.dao;


import com.roger.blog.model.Article;
import com.roger.blog.model.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 分页获取文章数据
     * @param article 文章
     * @param page 当前页数
     * @param limit 显示数
     */
     @Select("SELECT a.id id,a.title title,a.describes describes,a.create_date create_date," +
             "a.comment_count comment_count,c.name category FROM article a LEFT JOIN catalog c ON a.category = c.id " +
             " limit #{page},#{limit}")
     List<Article> getArticleListByLimt(Page page);

    /**
     * 获取文章总数
     * @param article 文章
     * @return
     */
     @Select("SELECT COUNT(id) FROM article")
     int getArticleCount();
}
