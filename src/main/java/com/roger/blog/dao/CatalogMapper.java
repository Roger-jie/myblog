package com.roger.blog.dao;

import com.roger.blog.model.Catalog;
import com.roger.blog.model.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatalogMapper {

    @Select("SELECT * FROM catalog limit #{page},#{limit}")
    List<Catalog> getCatalogLimit(Page page);

    @Select("SELECT COUNT(id) FROM catalog ")
    int getCatalogCount();

    @Insert("INSERT INTO catalog(name,remark) VALUES(#{name},#{remark})")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    void addCatalog(Catalog catalog);

    @Select("SELECT * FROM catalog")
    List<Catalog> getAllCatalog();
}
