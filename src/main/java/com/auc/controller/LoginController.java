package com.auc.controller;

import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Produce;
import com.auc.pojo.Role;
import com.auc.service.AdminService;
import com.auc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private AdminService adminService;

    //登录
    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String login(Admin admin, HttpServletRequest request) {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String str = null;
        Admin admin1=new Admin();
        admin1.setWorkerAccount(account);
        admin1.setWorkerPassword(password);
        Admin admins =loginService.login(admin1);
        if (admins != null) {

            request.getSession().setAttribute("admin", admins);
            //            查询角色名字集合
            List<Role> roleNameList=adminService.selectRoleList();
            request.getSession().setAttribute("roleNameList", roleNameList);
            //            查询角色名字集合状态
            List<Role> roleNameList2=adminService.selectRoleStateName();
            request.getSession().setAttribute("roleNameList2", roleNameList2);

            str = "登录成功";
        } else {
            str = "账号密码错误";
        }
        return str;
    }
    //显示菜单
    @RequestMapping(value = "/userMenus")
    public ModelAndView userMenus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("我的菜单显示了");
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Map<String, List<Menu>> MenuMap = loginService.findMenus(admin.getRoleId());//根据角色id显示不同的菜单
        ModelAndView modelAndView=new ModelAndView();
//        model.addAttribute("MenuMap",MenuMap);
        modelAndView.addObject("MenuMap",MenuMap);
        modelAndView.setViewName("/jsp/index.jsp");
        return modelAndView;
    }
}
