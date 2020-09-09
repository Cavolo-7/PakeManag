package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.White;
import com.auc.service.PersonManageService;
import com.auc.util.LayuiData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 白名单控制类
 */
@Controller
@RequestMapping("/personManage")
public class PersonManageControl {

    @Autowired
    PersonManageService personManageService;

    @RequestMapping("/white")
    @ResponseBody
    public String White(String page, String limit, HttpServletRequest request){
        System.out.println("进入白名单");
        String username = request.getParameter("key[username]");
        String account = request.getParameter("key[account]");
        String phone = request.getParameter("key[phone]");
        String worker = request.getParameter("key[worker]");
        String carnumber = request.getParameter("key[carnumber]");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        hashMap.put("username", username);
        hashMap.put("account", account);
        hashMap.put("phone", phone);
        hashMap.put("worker", worker);
        hashMap.put("carnumber", carnumber);
        HashMap hs = personManageService.queryWhite(hashMap);
        List<White> list = (List<White>) hs.get("list");
        int num = (int) hs.get("num");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(num);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String str= JSON.toJSONString(layuiData);

        return str;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String AddWhite(String username, String account,String phone, String carnumber, String pass){
        System.out.println("增加白名单");
        White white=new White(username,account,pass,carnumber,phone,6);
        boolean fal=personManageService.addWhite(white);
        if (fal) {
            return "增加成功";
        }else{
            return "增加失败";
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public String DelWhite(String whiteAccount){
        System.out.println("删除白名单");
        boolean fal=personManageService.delWhite(whiteAccount);
        if (fal) {
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String UpdWhite(String whiteAccount,String whiteName,String whiteCarnumber, String whitePhone){
        System.out.println("修改白名单");
        boolean fal=personManageService.updWhite(whiteAccount,whiteName,whiteCarnumber,whitePhone);
        if (fal) {
            return "编辑成功";
        }else{
            return "编辑失败";
        }
    }
}
