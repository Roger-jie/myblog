package com.roger.blog.dao;

import com.roger.blog.model.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TagMapper {

    String TAG_TABLE = "tag";

    @Select("SELECT * FROM "+TAG_TABLE)
    List<Tag> getAllTag();

    @Insert("insert into "+TAG_TABLE+"(name) value(#{name})")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    void saveTag(Tag tag);
}
