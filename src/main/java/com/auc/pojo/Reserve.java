package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能: 预约停车表实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-21 10:34:43
 **/
public class Reserve {

    private Integer reserveId;//id
    private String reserveCarNumber;//车牌号
    private String reserveTime;//预约时间

    private String carPort;//停车位信息
    private Integer flag;//（0-车位已满不可预约，1-已预约，2-当前时间该车已经预约（无法再预约）3-当前时间该车已经停车（无法再预约））

    public Reserve() {
    }

    public Reserve(Integer reserveId, String reserveCarNumber, String reserveTime, String carPort, Integer flag) {
        this.reserveId = reserveId;
        this.reserveCarNumber = reserveCarNumber;
        this.reserveTime = reserveTime;
        this.carPort = carPort;
        this.flag = flag;
    }

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public String getReserveCarNumber() {
        return reserveCarNumber;
    }

    public void setReserveCarNumber(String reserveCarNumber) {
        this.reserveCarNumber = reserveCarNumber;
    }

    public String getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public String getCarPort() {
        return carPort;
    }

    public void setCarPort(String carPort) {
        this.carPort = carPort;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "reserveId=" + reserveId +
                ", reserveCarNumber='" + reserveCarNumber + '\'' +
                ", reserveTime='" + reserveTime + '\'' +
                ", carPort='" + carPort + '\'' +
                ", flag=" + flag +
                '}';
    }
}