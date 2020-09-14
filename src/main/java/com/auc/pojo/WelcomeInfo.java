package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能: 出入场显示屏信息实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 22:55:46
 **/
public class WelcomeInfo {

    private String welcomeMsg;//欢迎信息(欢送信息)
    private Integer allNum;//车库总车位数
    private Integer useNum;//当前已占用车位数
    private Integer noNum;//当前空车位数
    private String carNumber;//车牌号
    private String carPort;//停车位
    private String startTime;//入场时间
    private String endTime;//出场时间
    private String longTime;//停放时长
    private String carType;//车辆类型（临时车辆，月缴车辆...）
    private Integer money;//应缴费用
    private String payState;//是否缴费信息（当收费完成，显示已缴费）

    private Integer carportId;//车位id

    public WelcomeInfo() {
    }

    public WelcomeInfo(String welcomeMsg, Integer allNum, Integer useNum, Integer noNum, String carNumber, String carPort, String startTime, String endTime, String longTime, String carType, Integer money, String payState, Integer carportId) {
        this.welcomeMsg = welcomeMsg;
        this.allNum = allNum;
        this.useNum = useNum;
        this.noNum = noNum;
        this.carNumber = carNumber;
        this.carPort = carPort;
        this.startTime = startTime;
        this.endTime = endTime;
        this.longTime = longTime;
        this.carType = carType;
        this.money = money;
        this.payState = payState;
        this.carportId = carportId;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getNoNum() {
        return noNum;
    }

    public void setNoNum(Integer noNum) {
        this.noNum = noNum;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarPort() {
        return carPort;
    }

    public void setCarPort(String carPort) {
        this.carPort = carPort;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLongTime() {
        return longTime;
    }

    public void setLongTime(String longTime) {
        this.longTime = longTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public Integer getCarportId() {
        return carportId;
    }

    public void setCarportId(Integer carportId) {
        this.carportId = carportId;
    }

    @Override
    public String toString() {
        return "WelcomeInfo{" +
                "welcomeMsg='" + welcomeMsg + '\'' +
                ", allNum=" + allNum +
                ", useNum=" + useNum +
                ", noNum=" + noNum +
                ", carNumber='" + carNumber + '\'' +
                ", carPort='" + carPort + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", longTime='" + longTime + '\'' +
                ", carType='" + carType + '\'' +
                ", money=" + money +
                ", payState='" + payState + '\'' +
                ", carportId=" + carportId +
                '}';
    }
}