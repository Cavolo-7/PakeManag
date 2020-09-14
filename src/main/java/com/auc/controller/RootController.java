package com.auc.controller;

import com.auc.pojo.Menu;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;
import com.auc.service.RootService;
import com.auc.service.UserService;
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

    @RequestMapping(value = "/rootAllot", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public  Object  rootAllotu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Menu> menuList = rootService.inquireMenu(0);//查询系统全部菜单

        String roleId = request.getParameter("roleId");
        System.out.println("我的Id:"+roleId);
        List<Menu> roleList = rootService.findMenu(Integer.parseInt(roleId));//获取该角色菜单

        TreeNode treeRootNode = new TreeNode();//定义根节点

        List<TreeNode> rootchildren = new ArrayList<>();//根节点的一级子节点
        treeRootNode.setId(0);//根节点id
        treeRootNode.setTitle("系统全部菜单");//根节点显示标题
        treeRootNode.setChildren(rootchildren);//根节点的子节点
        treeRootNode.setSpread(true);//根节点是否展开

        //遍历系统全部菜单，组装成tree数据源格式
        for (int i = 0; i < menuList.size(); i++) {

            TreeNode treeNode = new TreeNode();//定义一级菜单节点
            treeNode.setId(menuList.get(i).getMenuId());//一级菜单的id
            treeNode.setTitle(menuList.get(i).getMenuName());//一级菜单的标题
            List<TreeNode> children = new ArrayList<>();//一级菜单的子节点
            treeNode.setChildren(children);//添加至一级菜单的子节点

            //获取一级菜单对应的二级菜单 进行遍历
            List<Menu> twoMenuList = menuList.get(i).getMenuList();
            for (int j = 0; j < twoMenuList.size(); j++) {
                TreeNode treeTwoMenuNode = new TreeNode();//定义二级菜单节点
                children.add(treeTwoMenuNode);//将定义的二级菜单节点添加至一级菜单子节点中
                treeTwoMenuNode.setId(twoMenuList.get(j).getMenuId());//二级菜单的id
                treeTwoMenuNode.setTitle(twoMenuList.get(j).getMenuName());//二级菜单的标题

                for (int x = 0; x < roleList.size(); x++) {
                    for (int y = 0; y < roleList.get(x).getMenuList().size(); y++) {
                        if (twoMenuList.get(j).getMenuId().equals(roleList.get(x).getMenuList().get(y).getMenuId())) {
                            treeTwoMenuNode.setChecked(true);
                        }
                    }
                }
            }
            rootchildren.add(treeNode);//将定义的一级菜单节点添加至根节点的子节点中
        }

        return treeRootNode;
    }
}
