package com.auc.service.impl;

import com.auc.mapper.AdminMapper;
import com.auc.mapper.LogRegMapper;
import com.auc.pojo.Admin;
import com.auc.pojo.Person;
import com.auc.service.LogRegService;
import com.auc.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogRegServiceImpl implements LogRegService {

    @Autowired
    public LogRegMapper logRegMapper;

    //注册用户
    @Log()
    @Override
    public boolean regPerson(Person person) {
        boolean flag=false;
        int n=logRegMapper.regPerson(person);
        if (n>0){
            flag=true;
        }
        return flag;
    }
    //登录
    @Log()
    @Override
    public Person loginPerson(String personPhone) {
        Person person=new Person();
        person=logRegMapper.loginPerson(personPhone) ;
        return person;
    }

    //查询员工参数表性别
    @Log()
    @Override
    public Integer querySexParam(String sexName) {
        int n=logRegMapper.querySexParam(sexName);
        return n;
    }

    @Log()
    @Override
    public Person selectPersonAccount(String personAccount) {
        Person person=null;
        person=logRegMapper.selectPersonAccount(personAccount);
        return person;
    }

    @Log()
    @Override
    public Person selectPersonPhone(String personPhone) {
        Person person=null;
        person=logRegMapper.selectPersonPhone(personPhone);
        return person;
    }
}
