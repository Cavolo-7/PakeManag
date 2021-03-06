package com.auc.controller;

import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Produce;
import com.auc.pojo.Role;
import com.auc.service.AdminService;
import com.auc.service.LoginService;
import com.auc.service.PersonService;

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
    @Autowired
    private PersonService personService;
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
        boolean flag=loginService.chaState(account);
        if (flag==true){
        if (admins != null) {
            request.getSession().setAttribute("admin", admins);
            //查询收费管理员姓名集合
            List<Admin> adminList=adminService.selectAdminNameList();
            request.getSession().setAttribute("adminList", adminList);
            //            查询角色名字集合
            List<Role> roleNameList=adminService.selectRoleList();
            request.getSession().setAttribute("roleNameList", roleNameList);
//            //            查询角色名字集合状态
//            List<Role> roleNameList2=adminService.selectRoleStateName();
//            request.getSession().setAttribute("roleNameList2", roleNameList2);

            //            查询月缴产品名字集合
            List<Produce> produceList=personService.selectProduceNameList();
            request.getSession().setAttribute("produceList", produceList);
            //            查询月缴产品名字集合状态
//            List<Produce> produceList2=personService.selectProduceStateName();
//            request.getSession().setAttribute("produceList2", produceList2);

            str = "登录成功";

        } else {
            str = "账号密码错误";
        }
        }else {
            str="账户被禁用";
        }
        return str;
    }
    //显示菜单
    @RequestMapping(value = "/userMenus")
    public ModelAndView userMenus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Map<String, List<Menu>> MenuMap = loginService.findMenus(admin.getRoleId());//根据角色id显示不同的菜单
        ModelAndView modelAndView=new ModelAndView();
//        model.addAttribute("MenuMap",MenuMap);
        modelAndView.addObject("MenuMap",MenuMap);
        modelAndView.setViewName("/jsp/index.jsp");
        return modelAndView;
    }

    //人脸识别登录
    @RequestMapping(value = "/fecaLogin")
    @ResponseBody
    public Object fecaLogin(HttpServletRequest request) throws IOException {
        String str=null;
        System.out.println("人脸识别登录");
        String faceId = request.getParameter("faceId");
        System.out.println("jin:"+faceId);
        Admin admin = loginService.selectRoleId(faceId);
        System.out.println(admin.toString());
//        System.out.println("woshishshi:"+admin.getWorkerAccount());
        boolean flag = loginService.chaState(admin.getWorkerAccount());

        System.out.println(flag);
        if (flag == true) {
            request.getSession().setAttribute("admin", admin);
            //查询收费管理员姓名集合
            List<Admin> adminList = adminService.selectAdminNameList();
            request.getSession().setAttribute("adminList", adminList);
            //            查询角色名字集合
            List<Role> roleNameList = adminService.selectRoleList();
            request.getSession().setAttribute("roleNameList", roleNameList);
//            //            查询角色名字集合状态
//            List<Role> roleNameList2=adminService.selectRoleStateName();
//            request.getSession().setAttribute("roleNameList2", roleNameList2);

            //            查询月缴产品名字集合
            List<Produce> produceList = personService.selectProduceNameList();
            request.getSession().setAttribute("produceList", produceList);
            str = "1";
        }else {
            str = "账户被禁用";
        }
        return str;

//        return new Gson().toJson(1);
    }
}
