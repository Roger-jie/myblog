package com.roger.blog.provider;

import com.roger.blog.model.Article;
import com.roger.blog.util.PageUtils;
import com.roger.blog.util.StringUtil;
import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public final static String ARTICLE_TABLE = "article";

    public String findArticleByParamLimit(Article article){
        SQL sql = new SQL().SELECT("a.id id,a.title title,a.describes describes,a.create_date create_date,a.is_show is_show ," +
                "a.comment_count comment_count,c.name category,a.stick stick ").FROM(ARTICLE_TABLE+" a")
                .LEFT_OUTER_JOIN("catalog c ON a.category = c.id ");
        if (StringUtil.isNotEmpty(article.getTitle())) {
            sql.WHERE("title like concat('%',#{article.title},'%') ");
        }
        if (StringUtil.isNotEmpty(article.getCategory())) {
            sql.WHERE("category = #{article.category} ");
        }
        return PageUtils.getPageSql(sql.toString());
    }
}
