package com.roger.blog.controller;

import com.roger.blog.config.WebSecurityConfig;
import com.roger.blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Created by Administrator on 2017/12/14 0014.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) User user, Model model){
        model.addAttribute("user" ,user);
        return "index";
    }
}
