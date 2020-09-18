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
    public TreeNode rootAllot(HttpServletRequest request, HttpServletResponse response) {
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
        List<Param> paramList = rootService.selectRole(new Integer(page), new Integer(limit), paramName);
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
        String checkData = request.getParameter("checkData");//选中的数据
        System.out.println("checkdata：" + checkData);
        Integer value = new Integer(request.getParameter("value"));//权限等级id
        String str = "";
        boolean flag = false;
        if (checkData != null) {//有选择菜单项时
            TreeNode treeNode = new Gson().fromJson(checkData, TreeNode.class);
            List<TreeNode> oneMenuList = treeNode.getChildren();//一级菜单节点
            List<Integer> menuIdList = new ArrayList<>();//存放选中的菜单id
            for (int i = 0; i < oneMenuList.size(); i++) {
                menuIdList.add(oneMenuList.get(i).getId());//将一级菜单添加至menuIdList
                for (int j = 0; j < oneMenuList.get(i).getChildren().size(); j++) {//遍历一级菜单的子集（二级菜单列表）
                    menuIdList.add(oneMenuList.get(i).getChildren().get(j).getId());
                }
            }
            flag = rootService.UpdateMenu(menuIdList, value);//修改该权限等级菜单
            System.out.println("no");
        } else { //没有选择任何菜单项时
            flag = rootService.deleteAll(value);//移除该权限等级所有菜单
            System.out.println("null");
        }
        if (flag == true) {
            str = "success";
        } else {
            str = "error";
        }
        return str;
    }


}
