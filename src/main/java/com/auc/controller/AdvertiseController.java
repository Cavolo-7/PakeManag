package com.auc.controller;

import com.auc.pojo.Advertise;
import com.auc.service.impl.AdvertiseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-18 15:18:36
 **/
@Controller
@RequestMapping(value = "/advertise")
public class AdvertiseController {

    @Autowired
    private AdvertiseServiceImpl advertiseServiceImpl;

    /**
     * @Author: TheBigBlue
     * @Description: 查询广告列表
     * @Date: 2020/9/18
     * @return: java.util.List<com.auc.pojo.Advertise>
     **/
    @ResponseBody
    @RequestMapping(value = "/findAdvertiseList")
    public List<Advertise> findAdvertiseList() {
        List<Advertise> advertiseList = advertiseServiceImpl.findAdvertiseList();
        return advertiseList;
    }

}