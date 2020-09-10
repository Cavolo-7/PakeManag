package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.service.UserService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/userControl")
public class UserControl {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/selectRole", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectRole(HttpServletRequest request) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String roleName = request.getParameter("roleName");
        String urisdiction = request.getParameter("urisdiction");
        List<Role> roleList = userService.selectRole(new Integer(page), new Integer(limit), roleName, urisdiction);
        int count = userService.queryRoleCount();
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount(count);
        layuiData.setData(roleList);
        System.out.println("**-/-*"+count);
        System.out.println("**-/-*"+roleList.toString());
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    //增加角色管理员
    @RequestMapping(value = "/addRole", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String addRole(HttpServletRequest request) {
        System.out.println("打江聪");
        String paramName = request.getParameter("paramName");
        String roleName = request.getParameter("roleName");
        boolean flag = userService.addRole(paramName, roleName);
        if (flag==true){
            return  "增加成功";
        }else {
            return  "增加失败";
        }
    }
}
