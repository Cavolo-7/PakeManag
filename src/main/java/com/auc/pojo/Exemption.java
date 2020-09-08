package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能:  免检名单
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 14:41:23
 **/
public class Exemption {

    private Integer exemptionId;//免检名单id
    private String exemptionName;//免检名单用户名
    private String exemptionCarnumber;//车牌号
    private Date exemptionPaytime;//支付时间

    public Exemption() {
    }

    public Exemption(Integer exemptionId, String exemptionName, String exemptionCarnumber, Date exemptionPaytime) {
        this.exemptionId = exemptionId;
        this.exemptionName = exemptionName;
        this.exemptionCarnumber = exemptionCarnumber;
        this.exemptionPaytime = exemptionPaytime;
    }

    public Integer getExemptionId() {
        return exemptionId;
    }

    public void setExemptionId(Integer exemptionId) {
        this.exemptionId = exemptionId;
    }

    public String getExemptionName() {
        return exemptionName;
    }

    public void setExemptionName(String exemptionName) {
        this.exemptionName = exemptionName;
    }

    public String getExemptionCarnumber() {
        return exemptionCarnumber;
    }

    public void setExemptionCarnumber(String exemptionCarnumber) {
        this.exemptionCarnumber = exemptionCarnumber;
    }

    public Date getExemptionPaytime() {
        return exemptionPaytime;
    }

    public void setExemptionPaytime(Date exemptionPaytime) {
        this.exemptionPaytime = exemptionPaytime;
    }

    @Override
    public String toString() {
        return "Exemption{" +
                "exemptionId=" + exemptionId +
                ", exemptionName='" + exemptionName + '\'' +
                ", exemptionCarnumber='" + exemptionCarnumber + '\'' +
                ", exemptionPaytime=" + exemptionPaytime +
                '}';
    }
}