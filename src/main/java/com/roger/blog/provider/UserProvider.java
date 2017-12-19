package com.roger.blog.provider;

import com.roger.blog.model.User;
import com.roger.blog.util.StringUtil;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author  Roger
 *  User表SQL拼接类
 */
public class UserProvider {
        private final static String USER_TABLE = "user";

        public String findUserByParam(User user){
            SQL sql = new SQL().SELECT("*").FROM(USER_TABLE);
            String loginName = user.getLogin_name();
            if(StringUtil.isNotEmpty(loginName)){
                sql.WHERE("login_name = #{login_name}");
            }
            String name = user.getName();
            if(StringUtil.isNotEmpty(name)){
                sql.WHERE("name = #{name}");
            }
            return sql.toString();
        }
}
