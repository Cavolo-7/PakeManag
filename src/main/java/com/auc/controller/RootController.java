package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Menu;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;
import com.auc.service.RootService;
import com.auc.service.UserService;
import com.auc.util.LayuiData;
import com.google.gson.Gson;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/root")
public class RootController {

    @Autowired
    public RootService rootService;

    @ResponseBody
    @RequestMapping(value = "/rootAllot")
    public TreeNode rootAllot(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("value");
        TreeNode treeNode = rootService.findRootMenu(0, new Integer(id));
        return treeNode;
    }

    //查询所有用户信息
    @ResponseBody
    @RequestMapping(value = "/selectRole")
    public LayuiData selectRole(HttpServletRequest request) {
        String page = request.getParameter("page");
        String limit = request.getParameter("limit");
        String paramName = request.getParameter("paramName");
        List<Param> paramList = rootService.selectRole(new Integer(page), new Integer(limit),paramName);
        int count = rootService.queryRoleCount(paramName);
        LayuiData layuiData = new LayuiData();
        layuiData.setCode(0);
        layuiData.setMsg("");
        layuiData.setCount(count);
        layuiData.setData(paramList);
        return layuiData;
    }

    @ResponseBody
    @RequestMapping(value = "/updateMenu")
    public String updateMenu(HttpServletRequest request) {
        String checkData = request.getParameter("checkData");
        Integer value = new Integer(request.getParameter("value"));
        TreeNode treeNode = new Gson().fromJson(checkData, TreeNode.class);
        System.out.println(treeNode);

        List<TreeNode> oneMenuList = treeNode.getChildren();//一级菜单节点

        List<Integer> menuIdList = new ArrayList<>();
        for (int i = 0; i < oneMenuList.size(); i++) {
            menuIdList.add(oneMenuList.get(i).getId());
            for (int j = 0; j < oneMenuList.get(i).getChildren().size(); j++) {
                menuIdList.add(oneMenuList.get(i).getChildren().get(j).getId());
            }
        }
        System.out.println(menuIdList);
        boolean flag = rootService.UpdateMenu(menuIdList,value);
        String str = "";
        if (flag==true){
            str="success";
        }else {
            str="error";
        }
        return str;
    }


}
