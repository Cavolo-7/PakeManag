package com.auc.controller;

import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.service.AdminService;
import com.auc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private LoginService loginService;

    //登录
    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request) {
        String account = request.getParameter("account");

        String password = request.getParameter("password");
        System.out.println(account+" "+password);
        String str = null;
        Admin admin1=new Admin();
        admin1.setWorkerAccount(account);
        admin1.setWorkerPassword(password);
        Admin admins =loginService.login(admin1);
        if (admins != null) {
            request.getSession().setAttribute("admin", admins);
            str = "登录成功";
        } else {
            str = "账号密码错误";
        }
        return str;
    }

    @RequestMapping(value = "/userMenus")
    public String userMenus(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        Map<String, List<Menu>> MenuMap = loginService.findMenus(admin.getRoleId());//根据角色id显示不同的菜单
//        ModelAndView modelAndView=new ModelAndView();
        model.addAttribute("MenuMap",MenuMap);
//        modelAndView.addObject("MenuMap",MenuMap);
//        modelAndView.setViewName("/jsp/UserMenu.jsp");
        return "/jsp/UserMenu.jsp";
    }
}
