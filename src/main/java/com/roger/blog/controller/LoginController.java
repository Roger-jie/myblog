package com.roger.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录信息处理
 * @author  Roger
 */
@Controller
@RequestMapping("/login")
public class LoginController {

        @RequestMapping("/loginHtml")
        public String loginHtml(){
            return "login/login";
        }
       @RequestMapping("/signUp")
       public String signUp(){
            return "login/sign-up";
       }

}
