package com.roger.blog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.roger.blog.config.WebSecurityConfig;
import com.roger.blog.dao.UserMapper;
import com.roger.blog.model.User;
import com.roger.blog.model.json.AjaxJson;
import com.roger.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  roger
 *  用户信息操作
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getUserByLoginName")
    @ResponseBody
    public AjaxJson getUserByLoginName(String login_name) {
        User user = new User();
        user.setLogin_name(login_name);
        User getUser = userMapper.findUser(user);
        AjaxJson result = new AjaxJson();
        //result.put("valid",true);
        if (getUser != null) {
            result.setSuccess(false);
            result.setMsg("登录名已经存在");
        }
        return result;
    }

    /**
     * 新增用户
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value="/addUser" ,method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson addUser(User user){
        AjaxJson json = new AjaxJson();
        try{
            user.setPassword(MD5Util.string2MD5(user.getPassword()));
            userMapper.addUser(user);
            json.setSuccess(true);
            json.setMsg("用户保存成功");
        } catch (Exception e) {
            e.getMessage();
            json.setSuccess(false);
            json.setMsg("用户保存失败");
        }
        return json;
    }



}
