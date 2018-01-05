package com.roger.blog.dao;

import com.roger.blog.model.Catalog;
import com.roger.blog.model.Page;
import com.roger.blog.provider.CatalogProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatalogMapper {

   // @Select("SELECT * FROM catalog limit #{page},#{limit}")
    @SelectProvider(type = CatalogProvider.class,method = "findCatalogByParamLimit")
    List<Catalog> getCatalogLimit(@Param("catalog") Catalog catalog,@Param("page") Page page);

    @Select("SELECT COUNT(id) FROM catalog ")
    int getCatalogCount();

    @Insert("INSERT INTO catalog(name,remark) VALUES(#{name},#{remark})")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    void addCatalog(Catalog catalog);

    @Select("SELECT * FROM catalog")
    List<Catalog> getAllCatalog();
}
