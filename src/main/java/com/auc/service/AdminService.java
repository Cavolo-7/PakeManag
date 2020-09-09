package com.auc.service;

import com.auc.pojo.Admin;
import com.auc.pojo.LayuiData;

import java.util.Map;

public interface AdminService {

    //查询管理员列表表格数据
    public LayuiData<Admin> selectAdminList(Map<String, String> condition, Integer curPage, Integer pageSize);

    //删除管理员账号
    public boolean deleteAdmin(String workerAccount);

    //重置管理员密码
    public boolean updateAdminPassword(String workerAccount);
}
