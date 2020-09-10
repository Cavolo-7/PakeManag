package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Costrules;
import com.auc.service.CostruleService;
import com.auc.service.DetailService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class DetailControl {

    @Autowired
    DetailService detailService;

    @RequestMapping("/first")
    @ResponseBody
    public String Costrules(String page, String limit, HttpServletRequest request){
        System.out.println("临时用户和月缴用户");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = detailService.queryFirst(hashMap);
        List<Costrules> list = (List<Costrules>) hs.get("list");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(2);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    @RequestMapping("/second")
    @ResponseBody
    public String AddCostrules(String page, String limit, HttpServletRequest request){
        System.out.println("月缴用户不同产品包");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = detailService.querySecond(hashMap);
        List<Costrules> list = (List<Costrules>) hs.get("list");
        int num = (int) hs.get("num");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(num);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    @RequestMapping("/third")
    @ResponseBody
    public String DelCostrules(String page, String limit, HttpServletRequest request){
        System.out.println("自助缴费");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = detailService.queryThird(hashMap);
        List<Costrules> list = (List<Costrules>) hs.get("list");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(2);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    @RequestMapping("/fourth")
    @ResponseBody
    public String UpdCostrules(String page, String limit, HttpServletRequest request){
        System.out.println("修改计费规则");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = detailService.queryFourth(hashMap);
        List<Costrules> list = (List<Costrules>) hs.get("list");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(2);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }
}
