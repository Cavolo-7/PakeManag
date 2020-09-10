package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.service.AdminService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/getAdminList", produces = "text/plain;charset=utf-8")
    public String getAdminList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String adminName = request.getParameter("key[adminName]");
        String account = request.getParameter("key[account]");
        String phone = request.getParameter("key[phone]");
        String roleNames=request.getParameter("key[roleNames]");
        System.out.println(roleNames+"****");
        String curPageStr = request.getParameter("page");
        String pageSizeStr = request.getParameter("limit");
        Integer pageSize = 5;
        Integer curPage = 1;
        int a = 0;
        Map<String, String> condition = new HashMap<>();
        if (null != adminName && !"".equalsIgnoreCase(adminName)) {
            condition.put("adminName", adminName);
        }
        if (null != account && !"".equalsIgnoreCase(account)) {
            condition.put("account", account);
        }
        if (null != phone && !"".equalsIgnoreCase(phone)) {
            condition.put("phone", phone);
        }
        if (null != roleNames && !"".equalsIgnoreCase(roleNames)) {
            int n=adminService.selectRoleId(roleNames);
            condition.put("n", n+" ");
        }
        if (null != curPageStr && !"".equalsIgnoreCase(curPageStr)
                && null != pageSizeStr && !"".equalsIgnoreCase(pageSizeStr)) {
            curPage = Integer.parseInt(curPageStr);
            pageSize = Integer.parseInt(pageSizeStr);
            curPage = (curPage - 1) * pageSize;
        }
        LayuiData<Admin> layuiData = adminService.selectAdminList(condition, curPage, pageSize);
//        List<Admin> roleNameList=adminService.selectRoleList();
//        request.setAttribute("roleNameList",roleNameList);
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String str = JSON.toJSONString(layuiData);
        return str;
    }

   //管理员离职
    @RequestMapping(value = "/updateDimission", produces = "text/plain;charset=utf-8")
    public String updateDimission(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String workerAccount=request.getParameter("workerAccount");
        String stateName=request.getParameter("stateName");
        String str = null;
        int workerState=adminService.selectWorkerParam(stateName);
        Admin admin =new Admin();
        admin.setWorkerAccount(workerAccount);
        admin.setWorkerState(workerState);
        boolean flag=adminService.updateDimission(admin);
        if (flag==true){
            str="注销成功";
        }else {
            str="注销失败";
        }
        return str;
    }

    //重置管理员密码
    @RequestMapping(value = "/updateAdminPassword", produces = "text/plain;charset=utf-8")
    public String updateAdminPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String workerAccount=request.getParameter("workerAccount");
        boolean flag=adminService.updateAdminPassword(workerAccount);
        String str = null;
        if (flag==true){
            str="重置成功";
        }else {
            str="重置失败";
        }
        return str;
    }

    //添加管理员
    @RequestMapping(value = "/addAdmin", produces = "text/plain;charset=utf-8")
    public String addAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str=null;
        String workerAccount=request.getParameter("workerAccount");
        String workerName=request.getParameter("workerName");
        String workerAge=request.getParameter("workerAge");
        String sex=request.getParameter("sex");
        String phone=request.getParameter("phone");
        String workerAddress=request.getParameter("workerAddress");
        String roleName=request.getParameter("roleName");
        String stateName=request.getParameter("stateName");
        String L_pass=request.getParameter("repass");

        Admin admin2=adminService.selectAdminAccount(workerAccount);
        Admin admin3=adminService.selectAdminPhone(phone);
        if (admin2!=null) {
            str="账号已经存在";
        }else if (admin3!=null) {
            str="电话号码已存在";
        }else{
            int sexValue = adminService.selectParam(sex);
            int roleId = adminService.selectRoleId(roleName);
            int stateValue = adminService.selectWorkerParam(stateName);

            Admin admin = new Admin();
            admin.setWorkerAccount(workerAccount);
            admin.setWorkerName(workerName);
            admin.setWorkerAge(workerAge);
            admin.setWorkerSex(sexValue);
            admin.setWorkerPhone(phone);
            admin.setWorkerAddress(workerAddress);
            admin.setRoleId(roleId);
            admin.setWorkerState(stateValue);
            admin.setWorkerPassword(L_pass);

            boolean flag = adminService.addAdmin(admin);
            if (flag == true) {
                str = "增加成功";
            } else {
                str = "增加失败";
            }
        }
        return str;
    }

    //修改管理员禁用/启用状态
    @RequestMapping(value = "/updateAdminState", produces = "text/plain;charset=utf-8")
    public String updateAdminState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String workerAccount=request.getParameter("workerAccount");
        String stateName=request.getParameter("stateName");
        String str = null;
        int workerState=adminService.selectWorkerParam(stateName);
        Admin admin =new Admin();
        admin.setWorkerAccount(workerAccount);
        admin.setWorkerState(workerState);
        boolean flag=adminService.updateDimission(admin);
        if (flag==true){
            str="修改成功";
        }else {
            str="修改失败";
        }
        return str;
    }

    //修改管理员信息
    @RequestMapping(value = "/updateAdmin", produces = "text/plain;charset=utf-8")
    public String updateAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String str=null;
        String workerAccount=request.getParameter("workerAccount");
        String workerName=request.getParameter("workerName");
        String workerAge=request.getParameter("workerAge");
        String sex=request.getParameter("sex");
        String phone=request.getParameter("phone");
        String workerAddress=request.getParameter("workerAddress");
        String roleName=request.getParameter("roleName");
        String stateName=request.getParameter("stateName");
        String L_pass=request.getParameter("repass");

        Admin admin2=adminService.selectAdminPhone(phone);
        if (admin2!=null){
            if (admin2.getWorkerAccount().equals(workerAccount)){
                int sexValue = adminService.selectParam(sex);
                int roleId = adminService.selectRoleId(roleName);
                int stateValue = adminService.selectWorkerParam(stateName);

                Admin admin = new Admin();
                admin.setWorkerAccount(workerAccount);
                admin.setWorkerName(workerName);
                admin.setWorkerAge(workerAge);
                admin.setWorkerSex(sexValue);
                admin.setWorkerPhone(phone);
                admin.setWorkerAddress(workerAddress);
                admin.setRoleId(roleId);
                admin.setWorkerState(stateValue);
                admin.setWorkerPassword(L_pass);

                boolean flag = adminService.updateAdmin(admin);
                if (flag == true) {
                    str = "修改成功";
                } else {
                    str = "修改失败";
                }
            }else {
                str="该号码已存在";
            }
        }else {
            int sexValue = adminService.selectParam(sex);
            int roleId = adminService.selectRoleId(roleName);
            int stateValue = adminService.selectWorkerParam(stateName);

            Admin admin = new Admin();
            admin.setWorkerAccount(workerAccount);
            admin.setWorkerName(workerName);
            admin.setWorkerAge(workerAge);
            admin.setWorkerSex(sexValue);
            admin.setWorkerPhone(phone);
            admin.setWorkerAddress(workerAddress);
            admin.setRoleId(roleId);
            admin.setWorkerState(stateValue);
            admin.setWorkerPassword(L_pass);

            boolean flag = adminService.updateAdmin(admin);
            if (flag == true) {
                str = "修改成功";
            } else {
                str = "修改失败";
            }
        }
            return str;
    }

}
