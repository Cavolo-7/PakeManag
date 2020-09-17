package com.auc.service;

import com.auc.pojo.Person;

public interface LogRegService {


    //注册用户
    public boolean regPerson(Person person);

    //登录
    public  Person loginPerson(String personAccount ,String personAassword);

    //查询员工参数表性别
    public Integer querySexParam(String sexName);

    //查询用户账号是否存在
    public Person selectPersonAccount(String personAccount);

    //查询用户手机号码是否存在
    public  Person selectPersonPhone(String personPhone);
}
