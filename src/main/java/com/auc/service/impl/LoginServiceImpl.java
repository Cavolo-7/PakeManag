package com.auc.service.impl;

import com.auc.mapper.LoginMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import com.auc.service.LoginService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class LoginServiceImpl implements LoginService {
    //显示菜单
    @Autowired
    public LoginMapper loginMapper;
//    @Log(operationType = "查询",operationName = "查询菜单")
    @Override
    public Map<String, List<Menu>> findMenus(Integer roleId) {
        Role role=loginMapper.findRoot(roleId);
        HashMap<String,List<Menu>> menuMap=new HashMap();
        List<Menu> pMenus= loginMapper.findMenusByPid(0,role.getUrisdictionId());
        for (Menu menu:pMenus){
            List<Menu> sMenus=loginMapper.findMenusByPid(menu.getMenuId(),role.getUrisdictionId());
            menuMap.put(menu.getMenuName(),sMenus);
        };
        return menuMap;
    }

    //查询账号状态
    @Override
    public boolean chaState(String workerAccount) {
        boolean flag=false;
        Admin admin=loginMapper.chaState(workerAccount);
        if (admin!=null) {
            flag=true;
        }
        return flag;
    }

    //登录
    @Override
    public Admin login(Admin admin) {
        Admin admins = null;
        admins =loginMapper.login(admin);
        return admins;

    }

}
