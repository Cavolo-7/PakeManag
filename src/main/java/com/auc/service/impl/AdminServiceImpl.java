package com.auc.service.impl;

import com.auc.mapper.AdminMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;
import com.auc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    public AdminMapper adminMapper;

    //查询管理员列表表格数据
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
    @Override
    public boolean deleteAdmin(String workerAccount) {
        boolean flag = false;
        int a = adminMapper.deleteAdmin(workerAccount);
        if (a > 0) {
            flag = true;
        }
        return flag;
    }

    //重置管理员密码
    @Override
    public boolean updateAdminPassword(String workerAccount) {
        boolean flag=false;
        int n=adminMapper.updateAdminPassword(workerAccount);
        if (n>0){
            flag=true;
        }
        return flag;
    }


}
