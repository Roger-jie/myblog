package com.roger.blog.provider;

import com.roger.blog.model.Catalog;
import com.roger.blog.util.PageUtils;
import com.roger.blog.util.StringUtil;
import org.apache.ibatis.jdbc.SQL;

public class CatalogProvider {

    private final static String CATALOG_TABLE= "catalog";

    public String findCatalogByParamLimit(Catalog catalog){
        SQL sql = new SQL().SELECT("*").FROM(CATALOG_TABLE);
        if (StringUtil.isNotEmpty(catalog.getName())) {
            sql.WHERE("name like concat('%',#{catalog.name},'%')");
        }
        return PageUtils.getPageSql(sql.toString());
    }
}
