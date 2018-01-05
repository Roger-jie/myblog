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
            if(StringUtil.isNotEmpty(user.getLogin_name())){
                sql.WHERE("login_name = #{login_name} ");
            }
            if(StringUtil.isNotEmpty(user.getName())){
                sql.WHERE("name = #{name} ");
            }
            return sql.toString();
        }
}
