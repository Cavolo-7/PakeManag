package com.auc.controller;

import com.auc.pojo.Person;
import com.auc.service.LogRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/LogReg")
public class LogRegController {

    @Autowired
    public LogRegService logRegService;
    //注册
    @RequestMapping(value = "/regPerson", produces = "text/plain;charset=utf-8")
    public String regPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行注册方法");
        String str=null;
        String personName = request.getParameter("personName");
        String personAccount = request.getParameter("personAccount");
        String password = request.getParameter("password");
        String carNumber = request.getParameter("carNumber");
        String sex = request.getParameter("sex");
        String personAge = request.getParameter("personAge");
        String personPhone = request.getParameter("personPhone");
        String address=request.getParameter("address");

        System.out.println("我注册的信息是:"+"personName:"+personName + "password:"+password+ "personAccount:"+personAccount + "carNumber:"+carNumber + "sex:"+sex + "personAge:"+personAge + "personPhone:"+personPhone);
        Person person=logRegService.selectPersonAccount(personAccount);//查询用户账号是否存在
        Person person1=logRegService.selectPersonPhone(personPhone); //查询用户手机号码是否存在
        if (person!=null){
            str="账号已存在";
        }else if (person1!=null){
            str="电话号码已存在";
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
                str="注册成功";
            }else {
                str="注册失败";
            }
        }
        return str;

    }

    //登录
    @RequestMapping(value = "/loginPerson", produces = "text/plain;charset=utf-8")
    public String loginPerson(HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("执行用户登录方法");
        String personAccount=request.getParameter("personAccount");//获取账号
        String personPassword=request.getParameter("personPassword");//获取密码
        String str = null;
        Person person=logRegService.loginPerson(personAccount,personPassword);//调用登录方法传入账号密码
            if (person!=null){
                request.getSession().setAttribute("person",person);
                str = "登录成功";
            }else {
                str=  "登录失败";
//            }

        }
        return str;
    }

}
