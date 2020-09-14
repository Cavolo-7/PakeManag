package com.auc.util;

import com.auc.pojo.CarPort;
import com.auc.pojo.Costrules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 计费
 */
public class CountUtil {

    /**
     * 根据计费规则计算费用
     */
    public static Integer getMoney(List<Costrules> rulesList, Float hour) {
        int money = 0;
        if (rulesList != null) {
            for (int i = 0; i < rulesList.size(); i++) {
                if (rulesList.get(i).getCostrulesMin() != null && rulesList.get(i).getCostrulesMax() != null) {
                    if (rulesList.get(i).getCostrulesMin() <= hour && hour < rulesList.get(i).getCostrulesMax()) {
                        float baseHour = rulesList.get(i).getCostrulesMin();//基础时长
                        float lastHour = hour - rulesList.get(i).getCostrulesMin();//超出时长
                        int baseMoney = rulesList.get(i).getCostrulesBasemoney();//基础费用：元/小时
                        int lastMoney = rulesList.get(i).getCostrulesAddmoney();//增值费用：元/小时
                        money = (int) (baseMoney * baseHour + lastMoney * lastHour);//总费用
                        break;
                    }
                } else if (rulesList.get(i).getCostrulesMax() == null) {
                    if (rulesList.get(i).getCostrulesMin() <= hour) {
                        float baseHour = rulesList.get(i).getCostrulesMin();//基础时长
                        float lastHour = hour - rulesList.get(i).getCostrulesMin();//超出时长
                        int baseMoney = rulesList.get(i).getCostrulesBasemoney();//基础费用：元/小时
                        int lastMoney = rulesList.get(i).getCostrulesAddmoney();//增值费用：元/小时
                        money = (int) (baseMoney * baseHour + lastMoney * lastHour);//总费用
                        break;
                    }
                }
            }
        }
        return money;
    }

    /**
     * 计算停车时长多少小时（小时整）
     */
    public static Float getHour(Integer minute) {
        float hour = 0;
        if (minute != null) {
            int result = minute % 60;//取余
            if (result == 0) {
                hour = (float) (minute / 60);//停车多少小时
            } else if (30 < minute && minute < 60) {
                hour = (float) 0.5;
            } else {
                hour = (minute - result) / 60;//停车整小时
            }
        }
        return hour;
    }

    /**
     * 分配停车位
     */
    public static CarPort getCarParkPosition(List<CarPort> carPortList) {
        CarPort carPort = null;
        if (carPortList != null) {
            List<CarPort> noUseCarPortList = new ArrayList<>();//未占用车位
            for (int i = 0; i < carPortList.size(); i++) {
                if (carPortList.get(i).getCarportCarnumber() == null || carPortList.get(i).getCarportCarnumber().equals("")) {
                    noUseCarPortList.add(carPortList.get(i));
                }
            }
            int num = (int) (Math.random() * (noUseCarPortList.size()));
            carPort = noUseCarPortList.get(num);//分配的停车位
        }
        return carPort;
    }

}