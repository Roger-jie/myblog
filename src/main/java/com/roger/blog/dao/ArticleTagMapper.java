package com.roger.blog.dao;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Mapper
public interface ArticleTagMapper {

    String ARTICLE_TAG_TABLE = "article_tag";

    String TAG_TABLE = "tag";

    @Insert("insert into "+ARTICLE_TAG_TABLE+"(article_id,tag_id) values(#{article_id},#{tag_id})")
    void saveArticleTag(@Param("article_id") int article_id,@Param("tag_id") int tag_id);

    @Select("SELECT name FROM "+ TAG_TABLE +" t LEFT JOIN "+ARTICLE_TAG_TABLE +" at on t.id = at.tag_id " +
            " where at.article_id = #{articleId}")
    List<String> getTagNameByArticleId(@Param("articleId") String articleId);

    @Delete("delete FROM "+ ARTICLE_TAG_TABLE +" where article_id = #{articleId}")
    void deleteArticleTag(@Param("articleId") int articleId);
}
