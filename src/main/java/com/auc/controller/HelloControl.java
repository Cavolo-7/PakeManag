package com.auc.controller;

import com.auc.pojo.Admin;
import com.auc.service.LonginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/hello")
public class HelloControl {

    @Autowired
    LonginService longinService;

    @RequestMapping("/login")
//    转成JSON
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) throws IOException {
        boolean fal = false;
        System.out.println("进入管理员登陆系统");
        Admin admin = new Admin();
        admin.setVipAccount("666");
        admin.setVipPassword("999");
        Admin admin1 = longinService.Longin(admin);
        request.getSession().setAttribute("admin", admin1);
        System.out.println("有了吗"+admin);

        return null;
    }

}
