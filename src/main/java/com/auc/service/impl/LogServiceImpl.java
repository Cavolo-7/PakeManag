package com.auc.service.impl;

import com.auc.mapper.LogMapper;
import com.auc.pojo.Log;
import com.auc.pojo.White;
import com.auc.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @com.auc.util.Log()
    @Override
    public HashMap queryLog(HashMap hashMap) {
        List<Log> list = new ArrayList<Log>();
        HashMap hashMaps = new HashMap();
        int page = (int) hashMap.get("page");
        int pageSize = (int) hashMap.get("pageSize");
        String username = (String) hashMap.get("username");
        int num = 0;
        list=logMapper.queryLog(page,pageSize,username);
        num=logMapper.queryLogCount(username);
        hashMaps.put("list", list);
        hashMaps.put("num", num);
        return hashMaps;
    }
}
