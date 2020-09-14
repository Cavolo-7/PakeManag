package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.CarPort;
import com.auc.service.CarParkService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


@Controller
@RequestMapping("/carPark")
public class CarParkController {
    @Autowired
    private CarParkService carParkService;

    //总停车位表格数据
    @RequestMapping("/selectAllPark")
    @ResponseBody
    public String selectAllPark(String page, String limit,HttpServletRequest request) {
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = carParkService.selectAllParkList(hashMap);
        List<CarPort> list = (List<CarPort>) hs.get("list");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(1);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    //分区停车位表格数据
    @RequestMapping("/selectSubareaPark")
    @ResponseBody
    public String selectSubareaPark(String page, String limit,HttpServletRequest request) {
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = carParkService.selectSubareaParkList(hashMap);
        List<CarPort> list = (List<CarPort>) hs.get("list");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(2);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        System.out.println(str);
        return str;
    }
}
