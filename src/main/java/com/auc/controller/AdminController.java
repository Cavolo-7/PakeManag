package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
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

        if (null != curPageStr && !"".equalsIgnoreCase(curPageStr)
                && null != pageSizeStr && !"".equalsIgnoreCase(pageSizeStr)) {
            curPage = Integer.parseInt(curPageStr);
            pageSize = Integer.parseInt(pageSizeStr);
            curPage = (curPage - 1) * pageSize;
        }
        LayuiData<Admin> layuiData = adminService.selectAdminList(condition, curPage, pageSize);

//        Gson gson = new Gson();
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String str = JSON.toJSONString(layuiData);
        return str;
    }

    //删除管理员账号
    @RequestMapping(value = "/deleteAdmin", produces = "text/plain;charset=utf-8")
    public String deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String workerAccount=request.getParameter("workerAccount");
        System.out.println("****"+workerAccount);
        String str = null;
        boolean flag=adminService.deleteAdmin(workerAccount);
        if (flag==true){
            str="删除成功";
        }else {
            str="删除失败";
        }
        return str;
    }
}
