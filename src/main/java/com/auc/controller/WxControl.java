package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Person;
import com.auc.service.LogRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/wx")
public class WxControl {

    @Autowired
    public LogRegService logRegService;

    @RequestMapping("/login")
    @ResponseBody
    public String WxLogin(String account,String password,HttpServletResponse response){
//        System.out.println("进入微信小程序登陆");
//        Person person=logRegService.loginPerson(account,password);//调用登录方法传入账号密码
//        if (person!=null){
//            return JSON.toJSONString(person);
//        }else {
//            return JSON.toJSONString("登录失败");
//        }
        return null;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String WxRegister(String personName,String personAccount,String password,String carNumber,
                             String sex,String personAge,
                             String personPhone,String address,HttpServletResponse response){
        System.out.println("进入微信小程序注册");
        System.out.println(personName);
        System.out.println(personAccount);
        System.out.println(carNumber);
        System.out.println(sex);
        System.out.println(personAge);
        System.out.println(personPhone);
        System.out.println(address);
        System.out.println(password);
        Person person=logRegService.selectPersonAccount(personAccount);//查询用户账号是否存在
        Person person1=logRegService.selectPersonPhone(personPhone); //查询用户手机号码是否存在
        if (person!=null){
            return JSON.toJSONString("账号已存在");
        }else if (person1!=null){
            return JSON.toJSONString("电话号码已存在");
        }else {
            int sexValue = logRegService.querySexParam(sex);
            Person person2=new Person();
            person2.setPersonName(personName);
            person2.setPersonAccount(personAccount);
            person2.setPersonPassword(password);
            person2.setPersonCarnumber(carNumber);
            person2.setPersonSex(sexValue);
            person2.setPersonAge(Integer.parseInt(personAge));
            person2.setPersonPhone(personPhone);
            person2.setPersonAddress(address);
            boolean flag=logRegService.regPerson(person2);
            if (flag==true){
                return JSON.toJSONString("注册成功");
            }else {
                return JSON.toJSONString("注册失败");
            }
        }
    }
}
