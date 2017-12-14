package com.roger.blog.controller;

import com.roger.blog.dao.UserMapper;
import com.roger.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getUser")
    @ResponseBody
    public String getUser() {
         User user = userMapper.findUser("roger");
         return user.getName()+"------"+user.getLogin_name();
    }
}
