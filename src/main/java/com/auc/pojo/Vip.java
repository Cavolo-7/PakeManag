package com.auc.pojo;

import java.util.Date;

public class Vip {
    /**
     * Vip用户表实体类
     */
    private Integer vipId;//vip表id
    private String vipName;//vip用户名
    private String vipAccount;//vip账号
    private String vipPassword;//vip密码
    private String vipCarnumber;//vip车牌号
    private Integer vipSex;//vip用户性别
    private Integer vipAge;//vip用户年龄
    private String vipPhone;//vip用户电话号码
    private String vipAddress;//vip用户住址
    private Integer vipRecharge;//vip用户余额
    private Integer vipScore;//vip用户积分
    private Integer produceId;//产品id
    private Date vipStartime;//vip产品开通时间
    private Date vipEndtime;//vip产品结束时间
    private Integer workerId;//办理产品工作人员id

    public Vip() {
    }

    public Vip(Integer vipId, String vipName, String vipAccount, String vipPassword, String vipCarnumber, Integer vipSex, Integer vipAge, String vipPhone, String vipAddress, Integer vipRecharge, Integer vipScore, Integer produceId, Date vipStartime, Date vipEndtime, Integer workerId) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipAccount = vipAccount;
        this.vipPassword = vipPassword;
        this.vipCarnumber = vipCarnumber;
        this.vipSex = vipSex;
        this.vipAge = vipAge;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
        this.vipRecharge = vipRecharge;
        this.vipScore = vipScore;
        this.produceId = produceId;
        this.vipStartime = vipStartime;
        this.vipEndtime = vipEndtime;
        this.workerId = workerId;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipAccount() {
        return vipAccount;
    }

    public void setVipAccount(String vipAccount) {
        this.vipAccount = vipAccount;
    }

    public String getVipPassword() {
        return vipPassword;
    }

    public void setVipPassword(String vipPassword) {
        this.vipPassword = vipPassword;
    }

    public String getVipCarnumber() {
        return vipCarnumber;
    }

    public void setVipCarnumber(String vipCarnumber) {
        this.vipCarnumber = vipCarnumber;
    }

    public Integer getVipSex() {
        return vipSex;
    }

    public void setVipSex(Integer vipSex) {
        this.vipSex = vipSex;
    }

    public Integer getVipAge() {
        return vipAge;
    }

    public void setVipAge(Integer vipAge) {
        this.vipAge = vipAge;
    }

    public String getVipPhone() {
        return vipPhone;
    }

    public void setVipPhone(String vipPhone) {
        this.vipPhone = vipPhone;
    }

    public String getVipAddress() {
        return vipAddress;
    }

    public void setVipAddress(String vipAddress) {
        this.vipAddress = vipAddress;
    }

    public Integer getVipRecharge() {
        return vipRecharge;
    }

    public void setVipRecharge(Integer vipRecharge) {
        this.vipRecharge = vipRecharge;
    }

    public Integer getVipScore() {
        return vipScore;
    }

    public void setVipScore(Integer vipScore) {
        this.vipScore = vipScore;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public Date getVipStartime() {
        return vipStartime;
    }

    public void setVipStartime(Date vipStartime) {
        this.vipStartime = vipStartime;
    }

    public Date getVipEndtime() {
        return vipEndtime;
    }

    public void setVipEndtime(Date vipEndtime) {
        this.vipEndtime = vipEndtime;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vipId=" + vipId +
                ", vipName='" + vipName + '\'' +
                ", vipAccount='" + vipAccount + '\'' +
                ", vipPassword='" + vipPassword + '\'' +
                ", vipCarnumber='" + vipCarnumber + '\'' +
                ", vipSex=" + vipSex +
                ", vipAge=" + vipAge +
                ", vipPhone='" + vipPhone + '\'' +
                ", vipAddress='" + vipAddress + '\'' +
                ", vipRecharge=" + vipRecharge +
                ", vipScore=" + vipScore +
                ", produceId=" + produceId +
                ", vipStartime=" + vipStartime +
                ", vipEndtime=" + vipEndtime +
                ", workerId=" + workerId +
                '}';
    }
}
