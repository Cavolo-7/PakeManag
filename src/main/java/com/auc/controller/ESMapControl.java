package com.auc.controller;


import com.alibaba.fastjson.JSONObject;
import com.auc.pojo.CarPort;
import com.auc.service.ESMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/esmap")
public class ESMapControl {

    @Autowired
    ESMapService esMapService;

    @RequestMapping("/map")
    @ResponseBody
    public String QueryMap(){
        System.out.println("鸟瞰图查询");
        HashMap<String, List<CarPort>> hashMap=esMapService.QueryESMap();
        System.out.println(hashMap);
        String str=JSONObject.toJSONString(hashMap);
        return str;
    }
}
