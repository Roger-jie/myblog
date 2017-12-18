package com.roger.blog.dao;

import com.roger.blog.model.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@Mapper
public interface UserMapper {
    @Select("select * from User where login_name = #{login_name} and password = #{password}")
    User findUser(User user);

    //新增用户，用户状态为0，不可登录
    @Insert("insert into user (login_name , name, password ,head_url ,role ,email ,brief ,status) values(#{login_name},#{name}," +
            "#{password},#{head_url},#{role},#{email},#{brief},0)")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    void addUser(User user);


}
