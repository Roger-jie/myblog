package com.roger.blog.dao;


import com.roger.blog.model.Article;
import com.roger.blog.model.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    /**
     * 分页获取文章数据
     * @param article 文章
     * @param page 当前页数
     * @param limit 显示数
     */
     @Select("SELECT a.id id,a.title title,a.describes describes,a.create_date create_date,a.is_show is_show ," +
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

    /**
     * 新增文章
     * @param article
     */
     @Insert("insert into article (title , describes, create_date ,content,is_show ,comment_count ,category ,click,keyword ,md) values(#{title},"+
             "#{describes},NOW(),#{content},#{is_show},0,#{category},0,#{keyword},#{md})")
     @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
     void addArticle(Article article);

    /**
     * 通过id获取文章
     * @param id
     * @return
     */
     @Select("SELECT * FROM article WHERE id = #{id}")
     Article getArticleByID(@Param("id") String id);

    /**
     * 修改文章
     * @param article
     */

     @Update("UPDATE article SET title = #{title} ,describes = #{describes},content = #{content} , is_show = #{is_show}," +
             "category = #{category},keyword = #{keyword},md = #{md} where id = #{id}")
     void updateArticle(Article article);
}
