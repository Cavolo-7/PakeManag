package com.auc.service.impl;

import com.auc.mapper.AdminMapper;

import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.pojo.Person;
import com.auc.pojo.Role;
import com.auc.service.AdminService;
import com.auc.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminMapper adminMapper;

    //查询管理员列表表格数据
    @Log(operationName = "查找工作人员")
    @Override
    public LayuiData<Admin> selectAdminList(Map<String, String> condition, Integer curPage, Integer pageSize) {
        LayuiData<Admin> layuiData = new LayuiData();
        Integer record = adminMapper.selectAdminCount(condition);
        List<Admin> adminList = adminMapper.selectAdmin(condition, curPage, pageSize, record);
        layuiData.setData(adminList);
        layuiData.setMsg("");
        layuiData.setCode(0);
        layuiData.setCount(record);
        layuiData.setCurrPage(curPage);
        return layuiData;
    }

    //删除管理员账号
    @Log(operationName = "删除工作人员")
    @Override
    public boolean updateDimission(Admin admin) {
        boolean flag = false;
        int a = adminMapper.updateDimission(admin);
        if (a > 0) {
            flag = true;
        }
        return flag;
    }

    //查询参数id
    @Log()
    @Override
    public Integer selectParam(String paramName) {
        int n=adminMapper.selectParam(paramName);

        return n;
    }

    //重置管理员密码
    @Log(operationName = "重置管理员密码")
    @Override
    public boolean updateAdminPassword(String workerAccount) {
        boolean flag=false;
        int n=adminMapper.updateAdminPassword(workerAccount);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //添加管理员账号
    @Log(operationName = "添加管理员账号")
    @Override
    public boolean addAdmin(Admin admin) {
        boolean flag=false;
        int n=adminMapper.addAdmin(admin);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //查询角色id
    @Log()
    @Override
    public Integer selectRoleId(String roleName) {
        int n=adminMapper.selectRoleId(roleName);
        return n;
    }

    //查询员工状态参数id
    @Log()
    @Override
    public Integer selectWorkerParam(String paramName) {
        int n=adminMapper.selectWorkerParam(paramName);
        return n;
    }

    //查询员工性别参数id
    @Log()
    @Override
    public Integer selectSexParam(String sexName) {
        int n=adminMapper.selectSexParam(sexName);
        return n;
    }

    //查询管理员账号是否存在
    @Log()
    @Override
    public Admin selectAdminAccount(String workerAccount) {
        Admin admin=null;
        admin=adminMapper.selectAdminAccount(workerAccount);
        return admin;
    }

    //查询用户账号是否存在
    @Log()
    @Override
    public Person selectPersonAccount(String personAccount) {
        Person person=null;
        person=adminMapper.selectPersonAccount(personAccount);
        return person;
    }

    //查询管理员电话是否存在
    @Log()
    @Override
    public Admin selectAdminPhone(String workerPhoe) {
        Admin admin=null;
        admin=adminMapper.selectAdminPhone(workerPhoe);

        return admin;
    }

    //修改管理员信息
    @Log(operationName = "修改管理员信息")
    @Override
    public boolean updateAdmin(Admin admin) {
        boolean flag=false;
        int n=adminMapper.updateAdmin(admin);
        if (n>0){
            flag=true;
        }
        return flag;
    }

    //查询角色名字集合
    @Log()
    @Override
    public List<Role> selectRoleList() {
        List<Role> list=new ArrayList<Role>();

       list=adminMapper.selectRoleNameList();
        return list;
    }

    @Log()
    @Override
    public List<Role> selectRoleStateName() {
        List<Role> list=new ArrayList<Role>();

        list=adminMapper.selectRoleStateName();
        return list;
    }

    @Log()
    @Override
    public List<Admin> selectAdminNameList() {
        List<Admin> list=new ArrayList<Admin>();

        list=adminMapper.selectAdminNameList();
        return list;
    }


}
