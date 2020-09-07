package com.auc.service.impl;


import com.auc.mapper.AdminMapper;
import com.auc.pojo.Admin;
import com.auc.service.LonginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Longinimpl implements LonginService {


    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin Longin(Admin admin) {

        Admin admins = null;
        admins = adminMapper.Longin(admin);
        return admins;
    }

}
