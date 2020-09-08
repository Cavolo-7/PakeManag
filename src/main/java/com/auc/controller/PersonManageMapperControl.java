package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.White;
import com.auc.service.PersonManageService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class PersonManageMapperControl {

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
        System.out.println(pages);
        System.out.println(limit);
        HashMap hs = personManageService.queryWhite(hashMap);
        List<White> list = (List<White>) hs.get("list");
        int num = (int) hs.get("num");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(num);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

}
