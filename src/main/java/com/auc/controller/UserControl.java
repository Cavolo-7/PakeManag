package com.auc.controller;

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


    @RequestMapping("/selectRole")
    @ResponseBody
    public LayuiData selectRole(HttpServletRequest request){
        String page=request.getParameter("page");
        String limit=request.getParameter("limit");
        String roleName=request.getParameter("roleName");
        String urisdiction=request.getParameter("urisdiction");

        System.out.println("roleName"+roleName);
        System.out.println("urisdiction"+urisdiction);
        List<Role> roleList = userService.selectRole(new Integer(page),new Integer(limit),roleName,urisdiction);
        int count= userService.queryRoleCount();
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount(count);
        layuiData.setData(roleList);
        return layuiData;
    }


}
