package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.Costrules;
import com.auc.service.CostruleService;
import com.auc.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;


/**
 * 计费规则控制类
 */
@Controller
@RequestMapping("/costrules")
public class CostrulesControl {

    @Autowired
    CostruleService costruleService;

    @RequestMapping("/query")
    @ResponseBody
    public String Costrules(String page, String limit, HttpServletRequest request){
        System.out.println("进入计费规则");
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        HashMap hashMap = new HashMap();
        hashMap.put("page", pages);
        hashMap.put("pageSize", Integer.parseInt(limit));
        HashMap hs = costruleService.queryCostrule(hashMap);
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

    @RequestMapping("/add")
    @ResponseBody
    public String AddCostrules(String costrulesName
            ,String costrulesBasemoney,String costrulesAddmoney,String costrulesDescribe
            ,String costrulesBasemoney1,String costrulesAddmoney1,String costrulesDescribe1
            ,String costrulesBasemoney2,String costrulesAddmoney2,String costrulesDescribe2
            ,String costrulesBasemoney3,String costrulesAddmoney3,String costrulesDescribe3
            ,String costrulesBasemoney4,String costrulesAddmoney4,String costrulesDescribe4
    ){
        System.out.println("增加计费规则");

        boolean fal=costruleService.addCostrule(costrulesName
                ,costrulesBasemoney,costrulesAddmoney,costrulesDescribe
                ,costrulesBasemoney1,costrulesAddmoney1,costrulesDescribe1
                ,costrulesBasemoney2,costrulesAddmoney2,costrulesDescribe2
                ,costrulesBasemoney3,costrulesAddmoney3,costrulesDescribe3
                ,costrulesBasemoney4,costrulesAddmoney4,costrulesDescribe4
        );
        if (fal) {
            return "增加成功";
        }else{
            return "增加失败";
        }
    }

    @RequestMapping("/del")
    @ResponseBody
    public String DelCostrules(String costrulesName){
        System.out.println("删除计费规则");
        boolean fal=costruleService.delCostrule(costrulesName);
        if (fal) {
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String UpdCostrules(Integer costrulesId,String costrulesDescribe,Integer costrulesBasemoney,Integer costrulesAddmoney){
        System.out.println("修改计费规则");
        boolean fal=costruleService.updCostrule(costrulesId,costrulesDescribe,costrulesBasemoney,costrulesAddmoney);
        if (fal) {
            return "编辑成功";
        }else{
            return "编辑失败";
        }
    }

    @RequestMapping("/updstatic")
    @ResponseBody
    public String UpdStatic(String costrulesName,String costrulesState){
        System.out.println("计费规则禁用和启用");
        boolean fal=costruleService.UpdStatic(costrulesName,costrulesState);
        if (fal) {
            return costrulesState;
        }else{
            return "操作失败";
        }
    }
}
