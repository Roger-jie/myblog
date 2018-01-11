package com.roger.blog.dao;


import com.roger.blog.model.Article;
import com.roger.blog.model.Page;
import com.roger.blog.provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface ArticleMapper {

    String ARTICLE_TABLE = "article";

    /**
     * 分页获取文章数据
     * @param article 文章
     * @param page 当前页数
     * @param limit 显示数
     */
//     @Select("SELECT a.id id,a.title title,a.describes describes,a.create_date create_date,a.is_show is_show ," +
//             "a.comment_count comment_count,c.name category,a.stick stick FROM article a LEFT JOIN catalog c ON a.category = c.id " +
//             " limit #{page},#{limit}")
     @SelectProvider(type = ArticleProvider.class,method = "findArticleByParamLimit")
     List<Article> getArticleListByLimt(@Param("article") Article article,@Param("page") Page page);

    /**
     * 获取文章总数
     * @param article 文章
     * @return
     */
     @Select("SELECT COUNT(id) FROM "+ARTICLE_TABLE)
     int getArticleCount();

    /**
     * 新增文章
     * @param article
     */
     @Insert("insert into "+ ARTICLE_TABLE +" (title , describes, create_date ,content,is_show ,comment_count ,category ,click,keyword ,md,author,imgs,stick) values(#{title},"+
             "#{describes},NOW(),#{content},#{is_show},0,#{category},0,#{keyword},#{md},#{author},#{imgs},#{stick})")
     @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
     @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
     void addArticle(Article article);

    /**
     * 通过id获取文章
     * @param id
     * @return
     */
     @Select("SELECT * FROM "+ ARTICLE_TABLE +" WHERE id = #{id}")
     Article getArticleByID(@Param("id") String id);

    /**
     * 修改文章
     * @param article
     */

     @Update("UPDATE "+ ARTICLE_TABLE +" SET title = #{title} ,describes = #{describes},content = #{content} , is_show = #{is_show}," +
             "category = #{category},keyword = #{keyword},md = #{md} where id = #{id}")
     @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
     void updateArticle(Article article);

     @Delete("DELETE "+ ARTICLE_TABLE +" WHERE id = #{id}")
     @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
     void deleteArticle(@Param("id") String id);
}
