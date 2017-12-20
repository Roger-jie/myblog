package com.roger.blog.controller;

import com.roger.blog.config.WebSecurityConfig;
import com.roger.blog.dao.UserMapper;
import com.roger.blog.model.User;
import com.roger.blog.model.json.AjaxJson;
import com.roger.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 登录信息处理
 * @author  Roger
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/loginHtml")
    public String loginHtml(){
    return "login/login";
    }
    @RequestMapping("/signUp")
    public String signUp(){
    return "login/sign-up";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public AjaxJson loginUser(User user, HttpSession httpSession){
    AjaxJson json = new AjaxJson();
    user.setPassword(MD5Util.string2MD5(user.getPassword()));
    User getUser =  userMapper.userLogin(user);
    json.setSuccess(false);
    if (getUser != null && getUser.getStatus() == 0) {
        json.setMsg("用户被锁定,无法登录");
    }
    if (getUser == null) {
        json.setMsg("用户名密码错误");
    }
    if (getUser != null && getUser.getStatus() == 1) {
        json.setSuccess(true);
        httpSession.setAttribute(WebSecurityConfig.SESSION_KEY, getUser);
    }
    return json;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "login/login";
    }
}
