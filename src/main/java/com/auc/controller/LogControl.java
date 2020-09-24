package com.auc.controller;


import com.auc.pojo.Log;
import com.auc.service.LogService;
import com.auc.util.LayuiData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * 日志类
 */
@Controller
@RequestMapping("/log")
public class LogControl {

        @Autowired
        LogService logService;

        @RequestMapping("/QueryLog")
        @ResponseBody
        public String QueryLog(String page, String limit, HttpServletRequest request){
            System.out.println("进入日志");
            String username = request.getParameter("key[worker]");
            int pages = Integer.parseInt(limit) * (Integer.parseInt(page) - 1);
            HashMap hashMap = new HashMap();
            hashMap.put("page", pages);
            hashMap.put("pageSize", Integer.parseInt(limit));
            hashMap.put("username", username);
            HashMap hs = logService.queryLog(hashMap);
            List<Log> list = (List<Log>) hs.get("list");
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
