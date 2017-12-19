package com.roger.blog.dao;

import com.roger.blog.model.User;
import com.roger.blog.provider.UserProvider;
import org.apache.ibatis.annotations.*;

/**
 * @author  Roger
 */
@Mapper
public interface UserMapper {
   //根据登录名和密码获取用户
    @Select("select * from User where login_name = #{login_name} and password = #{password}")
    User userLogin(User user);

    //新增用户，用户状态为0，不可登录
    @Insert("insert into user (login_name , name, password ,head_url ,role ,email ,brief ,status) values(#{login_name},#{name}," +
            "#{password},#{head_url},#{role},#{email},#{brief},0)")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    void addUser(User user);

    //根据参数获取User
    @SelectProvider(type = UserProvider.class, method = "findUserByParam")
    User findUser(User user);
}
