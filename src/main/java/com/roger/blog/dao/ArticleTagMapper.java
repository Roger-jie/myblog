package com.roger.blog.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/1/9 0009.
 */
@Mapper
public interface ArticleTagMapper {

    String ARTICLE_TAG_TABLE = "article_tag";

    @Insert("insert into "+ARTICLE_TAG_TABLE+"(article_id,tag_id) values(#{article_id},#{tag_id})")
    void saveArticleTag(@Param("article_id") int article_id,@Param("tag_id") int tag_id);
}
