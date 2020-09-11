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
    private String vipCarNumber;//vip车牌号
    private Integer vipSex;//vip用户性别
    private Integer vipAge;//vip用户年龄
    private String vipPhone;//vip用户电话号码
    private String vipAddress;//vip用户住址
    private Integer vipRecharge;//vip用户余额
    private Integer vipScore;//vip用户积分
    private Integer produceId;//产品id
    private String vipStarTime;//vip产品开通时间
    private String vipEndTime;//vip产品结束时间
    private Integer workerId;//办理产品工作人员id


    private String sexName;//性别名称
    private String produceName;//产品名称
    private String workerName;//收费员操作姓名
    private Integer produceMonths;//产品月份
    private Date strTime;//获取计算好的月份时间

    public Vip() {
    }

    public Vip(Integer vipId, String vipName, String vipAccount, String vipPassword, String vipCarNumber, Integer vipSex, Integer vipAge, String vipPhone, String vipAddress, Integer vipRecharge, Integer vipScore, Integer produceId, String vipStarTime, String vipEndTime, Integer workerId, String sexName, String produceName, String workerName, Integer produceMonths, Date strTime) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipAccount = vipAccount;
        this.vipPassword = vipPassword;
        this.vipCarNumber = vipCarNumber;
        this.vipSex = vipSex;
        this.vipAge = vipAge;
        this.vipPhone = vipPhone;
        this.vipAddress = vipAddress;
        this.vipRecharge = vipRecharge;
        this.vipScore = vipScore;
        this.produceId = produceId;
        this.vipStarTime = vipStarTime;
        this.vipEndTime = vipEndTime;
        this.workerId = workerId;
        this.sexName = sexName;
        this.produceName = produceName;
        this.workerName = workerName;
        this.produceMonths = produceMonths;
        this.strTime = strTime;
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

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getVipCarNumber() {
        return vipCarNumber;
    }

    public void setVipCarNumber(String vipCarNumber) {
        this.vipCarNumber = vipCarNumber;
    }

    public String getVipStarTime() {
        return vipStarTime;
    }

    public void setVipStarTime(String vipStarTime) {
        this.vipStarTime = vipStarTime;
    }

    public String getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(String vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getProduceMonths() {
        return produceMonths;
    }

    public void setProduceMonths(Integer produceM) {
        this.produceMonths = produceM;
    }

    public Date getStrTime() {
        return strTime;
    }

    public void setStrTime(Date strTime) {
        this.strTime = strTime;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vipId=" + vipId +
                ", vipName='" + vipName + '\'' +
                ", vipAccount='" + vipAccount + '\'' +
                ", vipPassword='" + vipPassword + '\'' +
                ", vipCarNumber='" + vipCarNumber + '\'' +
                ", vipSex=" + vipSex +
                ", vipAge=" + vipAge +
                ", vipPhone='" + vipPhone + '\'' +
                ", vipAddress='" + vipAddress + '\'' +
                ", vipRecharge=" + vipRecharge +
                ", vipScore=" + vipScore +
                ", produceId=" + produceId +
                ", vipStarTime='" + vipStarTime + '\'' +
                ", vipEndTime='" + vipEndTime + '\'' +
                ", workerId=" + workerId +
                ", sexName='" + sexName + '\'' +
                ", produceName='" + produceName + '\'' +
                ", workerName='" + workerName + '\'' +
                ", produceMonths=" + produceMonths +
                ", strTime='" + strTime + '\'' +
                '}';
    }
}
