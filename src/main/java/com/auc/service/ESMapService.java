package com.auc.service;

import com.auc.pojo.CarPort;

import java.util.HashMap;
import java.util.List;

public interface ESMapService {

    public HashMap<String, List<CarPort>> QueryESMap();
}
