package com.auc.service.impl;

import com.auc.mapper.CarInMapper;
import com.auc.mapper.RootMapper;
import com.auc.pojo.Menu;
import com.auc.pojo.Param;
import com.auc.pojo.Role;
import com.auc.pojo.TreeNode;
import com.auc.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    public RootMapper rootMapper;

    @com.auc.util.Log()
    @Override
    public List<Param> selectRole(Integer page, Integer limit, String paramName) {
        page = (page - 1) * limit;
        List<Param> roleList = rootMapper.selectRole(page, limit, paramName);
        return roleList;
    }

    //查询总页数
    @com.auc.util.Log()
    @Override
    public Integer queryRoleCount(String paramName) {
        int count = rootMapper.queryRoleCount(paramName);
        return count;
    }

    //根据权限等级查询对应的菜单
    @com.auc.util.Log()
    @Override
    public TreeNode findRootMenu(Integer parentId, Integer urisdictionId) {
        List<Menu> menuList = rootMapper.inquireMenu(parentId);//查询系统全部菜单
        System.out.println("查询系统全部菜单：" + menuList);

        List<Menu> roleList = rootMapper.findAdminMenuById(parentId, urisdictionId);//获取该角色菜单
        System.out.println("获取该角色菜单：" + roleList);

        TreeNode treeRootNode = new TreeNode();//定义根节点

        treeRootNode.setId(0);//根节点id
        treeRootNode.setTitle("系统全部菜单");//根节点显示标题
        treeRootNode.setSpread(true);//根节点是否展开
        List<TreeNode> rootchildren = new ArrayList<>();//根节点的一级子节点
        treeRootNode.setChildren(rootchildren);//根节点的子节点


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
        System.out.println("根节点:" + treeRootNode);
        return treeRootNode;
    }


    //修改权限等级所分配的菜单
    @com.auc.util.Log()
    @Transactional
    @Override
    public boolean UpdateMenu(List<Integer> menuIdList, Integer urisdictionId) {
        int deleteAllNum = rootMapper.deleteAll(urisdictionId);//删除该权限等级所有菜单
        HashMap hashMap = new HashMap();
        hashMap.put("urisdictionId", urisdictionId);
        hashMap.put("list", menuIdList);
        int insertAllNum = rootMapper.insertAll(hashMap);//新增该权限等级所分配的菜单
        boolean flag = false;
        if (insertAllNum > 0) {
            flag = true;
        }
        return flag;
    }

    //删除该权限等级所有分配的菜单
    @com.auc.util.Log()
    @Transactional
    @Override
    public boolean deleteAll(Integer urisdictionId) {
        int deleteAllNum = rootMapper.deleteAll(urisdictionId);//删除所有菜单
        System.out.println("deleteAllNum：" + deleteAllNum);
        boolean flag = false;
        if (deleteAllNum > 0) {
            flag = true;
        }
        return flag;
    }


}
