package com.roger.blog.dao;

import com.roger.blog.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@Mapper
public interface UserMapper {
    @Select("select * from User where login_name = #{loginName} and password = #{password}")
    User findUser(@Param("loginName") String loginName,@Param("password") String password);
}
