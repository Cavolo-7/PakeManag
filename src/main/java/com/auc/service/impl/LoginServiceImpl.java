package com.auc.service.impl;

import com.auc.mapper.LoginMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.Menu;
import com.auc.pojo.Role;
import com.auc.service.LoginService;
import com.auc.util.Log;
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
    @Log()
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
    @Log()
    @Override
    public boolean chaState(String workerAccount) {
        boolean flag=false;
        Admin admin=loginMapper.chaState(workerAccount);
        System.out.println(admin);
        if (admin!=null) {
            flag=true;
        }
        return flag;
    }

    //登录
    @Log()
    @Override
    public Admin login(Admin admin) {
        Admin admins = null;
        admins =loginMapper.login(admin);
        return admins;

    }

    //人脸识别登录
    @Log()
    @Override
    public Admin fecaLogin(String workerName) {
        Admin admin1=null;
        admin1=loginMapper.fecaLogin(workerName);
        System.out.println("我的名字:"+workerName);
        return admin1;
    }
    //查询角色id
    @Log()
    @Override
    public Admin selectRoleId(String faceId) {
        System.out.println("角色名字:"+faceId);
        Admin admin=loginMapper.selectRoleId(faceId);
        System.out.println("角色名字122121:"+admin.toString());
        return admin;
    }

}
