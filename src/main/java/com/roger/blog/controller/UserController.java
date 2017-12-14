package com.roger.blog.controller;

import com.roger.blog.dao.UserMapper;
import com.roger.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author  roger
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/getUser")
    public String getUser(Model model) {
         User user = userMapper.findUser("roger","123456");
         model.addAttribute("people", user);
        return "index";
    }
}
