package com.auc.controller;

import com.alibaba.fastjson.JSON;
import com.auc.pojo.White;
import com.auc.service.TimingService;
import com.auc.util.LayuiData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/settle")
public class SettleController {

    @Autowired
    TimingService timingService;

    @RequestMapping("/getSettle")
    @ResponseBody
    public String getSettle(String page, String limit, HttpServletRequest request){
        String judgeTime = request.getParameter("key[judgeTime]");
        System.out.println("早午晚班："+judgeTime);
        int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
        if (judgeTime==null||judgeTime.equals("")){
            judgeTime="morning";
        }
        HashMap hs =new HashMap();
        if (judgeTime.equals("morning")){
            hs=timingService.Sttlement(pages,Integer.parseInt(limit));
        }else if (judgeTime.equals("noon")){
            hs=timingService.Sttlement2(pages,Integer.parseInt(limit));
        }else if (judgeTime.equals("evening")){
            hs=timingService.Sttlement3(pages,Integer.parseInt(limit));
        }
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
}
