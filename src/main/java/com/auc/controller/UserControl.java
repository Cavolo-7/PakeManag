package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Param;
import com.auc.pojo.Person;
import com.auc.pojo.Role;
import com.auc.service.LogRegService;
import com.auc.service.UserService;
import com.auc.util.LayuiData;
import com.auc.util.Textmessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/userControl")
public class UserControl {

    private String code2;

    @Autowired
    public UserService userService;
    @Autowired
    public LogRegService logRegService;

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

    @RequestMapping(value = "/textMsg", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public void textMsg(HttpServletRequest request, HttpServletResponse response)throws IOException, ParseException{
        code2="";
        for (int i=0;i<4;i++){
            code2+=(int)Math.floor(Math.random()*10);
        }
//        request.getSession().setAttribute("code",str);

        //获取前台传送过来的手机号码
        String personPhone=request.getParameter("personPhone");
        boolean flag=Textmessage.sender(personPhone,code2);
    }

    //校验短信验证码
    @RequestMapping(value = "/textCod", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String textCod(HttpServletRequest request, HttpServletResponse response)throws IOException, ParseException {
      String str=null;
       //前台输入的验证码
        String code=request.getParameter("code");
        String personPhone=request.getParameter("personPhone");
       //后台发生的验证码
        if (code2.equals(code)){
            Person person=logRegService.loginPerson(personPhone);
            if (person!=null){
                return JSON.toJSONString(person);
            }else {
                return JSON.toJSONString("登录失败");
            }
        }else {
            return JSON.toJSONString("验证失败") ;
        }
    }
}
