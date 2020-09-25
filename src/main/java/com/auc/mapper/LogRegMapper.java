package com.auc.mapper;

import com.auc.pojo.Admin;
import com.auc.pojo.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper   //这个注解代表是mybatis中的一个mapper类
@Repository  //将这个类注入spring容器
public interface LogRegMapper {

     //注册用户
     public Integer regPerson(Person person);

    //登录
    public  Person loginPerson(String personPhone);

     //查询员工参数表性别
    public Integer querySexParam(String sexName);

    //查询用户账号是否存在
    public Person selectPersonAccount(String personAccount);

    //查询管理员手机号码是否存在
    public  Person selectPersonPhone(String personPhone);


}
