package com.auc.controller;


import com.alibaba.fastjson.JSONObject;
import com.auc.pojo.CarPort;
import com.auc.service.ESMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        String str=JSONObject.toJSONString(hashMap);
        return str;
    }

    @RequestMapping("/photo")
    @ResponseBody
    public String QueryPhoto(String carNumber){
        System.out.println("照片查询");
        CarPort carPort=esMapService.Search(carNumber);
        String str=JSONObject.toJSONString(carPort);
        return str;
    }


    @RequestMapping("/search")
    @ResponseBody
    public String Search(String carNumber,String area, HttpServletRequest request){
        CarPort carPort=esMapService.Search(carNumber);
        request.getSession().setAttribute("carPort",carPort);
        switch (area){
            case "A":
                request.getSession().setAttribute("starPointX","12728414.839074487");
                request.getSession().setAttribute("starPointY","3551718.675046414");
                break;
            case "B":
                request.getSession().setAttribute("starPointX","12728428.542912988");
                request.getSession().setAttribute("starPointY","3551691.0705296528");
                break;
            case "C":
                request.getSession().setAttribute("starPointX","12728414.228737442");
                request.getSession().setAttribute("starPointY","3551663.9985796087");
                break;
            case "D":
                request.getSession().setAttribute("starPointX","12728375.602663573");
                request.getSession().setAttribute("starPointY","3551666.565332011");
                break;
            default:
                request.getSession().setAttribute("starPointX","12728414.839074488");
                request.getSession().setAttribute("starPointY","3551718.675046414");
        }
        return "成功";

    }
}
