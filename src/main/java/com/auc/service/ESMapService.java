package com.auc.service;

import com.auc.pojo.CarPort;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;

public interface ESMapService {

    public HashMap<String, List<CarPort>> QueryESMap();

    public CarPort Search(String carNumber);
}
