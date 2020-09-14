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
import javax.servlet.http.HttpServletResponse;
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
        String roleState =request.getParameter("roleState");
        List<Role> roleList = userService.selectRole(new Integer(page), new Integer(limit), roleName, urisdiction,roleState);
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
    //修改
    @RequestMapping(value = "/updRole", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updRole(String roleId,String roleName,String urisdictionName){
        System.out.println("我来打江聪了111111");
        System.out.println("我是:"+roleId);
        boolean flag=userService.updRole(roleId,roleName,urisdictionName);
        if (flag){
            return "编辑成功";
        }else{
            return "编辑失败";
        }

    }

    //禁用启用
    @RequestMapping(value = "/roleState", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String roleState(Integer roleId,String roleState){
        System.out.println("用户管理禁用和启用");
        boolean flag=userService.roleState(roleId,roleState);
        System.out.println("我的id:"+roleId);
        System.out.println("我的状态:"+roleState);
        if (flag){
            return roleState;
        }else{
            return "操作失败";
        }
    }
}
