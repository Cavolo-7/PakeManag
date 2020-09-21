package com.auc.service.impl;

import com.auc.mapper.AdminMapper;
import com.auc.mapper.AdvertiseMapper;
import com.auc.mapper.CarInMapper;
import com.auc.pojo.Advertise;
import com.auc.service.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @基本功能:
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-18 15:14:13
 **/
@Service
public class AdvertiseServiceImpl implements AdvertiseService {

    @Autowired
    private AdvertiseMapper advertiseMapper;

    /**
     * @Author: TheBigBlue
     * @Description: 查询广告列表
     * @Date: 2020/9/18
     * @return: java.util.List<com.auc.pojo.Advertise>
     **/
    @Override
    public List<Advertise> findAdvertiseList() {
        List<Advertise> advertises = advertiseMapper.findAdvertiseList();
        return advertises;
    }
}