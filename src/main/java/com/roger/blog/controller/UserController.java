package com.roger.blog.controller;

import com.roger.blog.dao.UserMapper;
import com.roger.blog.model.User;
import com.roger.blog.model.json.AjaxJson;
import com.roger.blog.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  roger
 *  用户信息操作
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getUser")
    public String getUser(Model model,User user) {
        user.setLogin_name("roger");
        user.setPassword("123456");
         User user1 = userMapper.findUser(user);
         model.addAttribute("people", user);
        return "index";
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
