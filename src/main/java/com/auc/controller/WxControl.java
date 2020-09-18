package com.auc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/wx")
public class WxControl {

    @RequestMapping("/login")
    @ResponseBody
    public String WxLogin(HttpServletResponse response){
        System.out.println("进入微信小程序");
        return "hello world";
    }
}
