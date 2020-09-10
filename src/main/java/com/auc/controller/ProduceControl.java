package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Produce;
import com.auc.service.ProduceService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 月缴产品控制类
 */
@Controller
@RequestMapping("/produce")
public class ProduceControl {

    @Autowired
    ProduceService produceService;

    @RequestMapping("query")
    @ResponseBody
    public String Produce(String page, String limit, HttpServletRequest request){
        System.out.println("进入产品管理");
        String produceStatic = request.getParameter("key[produceStatic]");
        String produceName = request.getParameter("key[produceName]");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        hashMap.put("produceStatic", produceStatic);
        hashMap.put("produceName", produceName);
        HashMap hs=produceService.queryProduce(hashMap);
        List<Produce> list = (List<Produce>) hs.get("list");
        int num = (int) hs.get("num");
        LayuiData layuiData=new LayuiData();
        layuiData.setCode(0);
        layuiData.setCount(num);
        layuiData.setMsg("查无此数据");
        layuiData.setData(list);
        String str= JSON.toJSONString(layuiData);
        return str;
    }

    @RequestMapping("/add")
    @ResponseBody
    public String AddProduce(String produceName, String produceDescribe,String produceMoney,String produceTime){
        System.out.println("增加产品管理");
        boolean fal=produceService.addProduce(produceName,produceDescribe,produceMoney,produceTime);
        if (fal) {
            return "增加成功";
        }else{
            return "增加失败";
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public String DelProduce(String produceId,String produceStatic){
        System.out.println("产品管理启用禁用");
        System.out.println(produceId);
        boolean fal=produceService.delProduce(produceId,produceStatic);
        if (fal) {
            return produceStatic;
        }else{
            return "操作失败";
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String UpdProduce(String produceId,String produceName,String produceMoney){
        System.out.println("修改产品管理");
        boolean fal=produceService.updProduce(produceId,produceName,produceMoney);
        if (fal) {
            return "编辑成功";
        }else{
            return "编辑失败";
        }
    }
}
