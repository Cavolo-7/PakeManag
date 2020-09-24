package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Costrules;
import com.auc.service.CostruleService;
import com.auc.service.DetailService;
import com.auc.util.LayuiData;
import com.auc.util.ReportDataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class DetailControl {

    @Autowired
    DetailService detailService;

    @RequestMapping("/first")
    @ResponseBody
    public String Costrules(HttpServletRequest request){
        System.out.println("临时用户和月缴用户");
        HashMap hashMap = new HashMap();
        HashMap hs = detailService.queryFirst(hashMap);
        List<Integer> list = (List<Integer>) hs.get("list");
        ReportDataBean bean=new ReportDataBean();
        bean.setData(list);
        String str= JSON.toJSONString(bean);
        return str;
    }

    @RequestMapping("/second")
    @ResponseBody
    public String AddCostrules( HttpServletRequest request){
        System.out.println("月缴用户不同产品包");
        HashMap hashMap = new HashMap();
        HashMap hs = detailService.querySecond(hashMap);
        String str= JSON.toJSONString(hs);
        return str;
    }

    @RequestMapping("/third")
    @ResponseBody
    public String DelCostrules(HttpServletRequest request){
        System.out.println("自助缴费");
        HashMap hashMap = new HashMap();
        HashMap hs = detailService.queryThird(hashMap);
        List<Integer> list = (List<Integer>) hs.get("list");
        ReportDataBean bean=new ReportDataBean();
        bean.setData(list);
        String str= JSON.toJSONString(bean);
        return str;
    }

    @RequestMapping("/fourth")
    @ResponseBody
    public String UpdCostrules( HttpServletRequest request){
        System.out.println("总收入");
        HashMap hashMap = new HashMap();
        HashMap hs = detailService.queryFourth(hashMap);
        List<Integer> list = (List<Integer>) hs.get("list");
        ReportDataBean bean=new ReportDataBean();
        bean.setData(list);
        String str= JSON.toJSONString(bean);
        return str;
    }
}
