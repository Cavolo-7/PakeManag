package com.auc.service;

import com.auc.pojo.Detail;

import java.util.HashMap;
import java.util.List;

public interface TimingService {

    public void JudgeVip(); //判断会员

    public HashMap Sttlement(Integer page, Integer limit); //统计早结算

    public HashMap Sttlement2(Integer page, Integer limit); //统计午结算

    public HashMap Sttlement3(Integer page, Integer limit); //统计晚结算
}
