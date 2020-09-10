package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能:  历史记录实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 15:54:21
 **/
public class History {

    private Integer historId;//历史记录id
    private String historCarnumber;//车牌号
    private Date historStartime;//开始停车时间
    private Date historEndtime;//结束时间
    private Integer historMoney;//费用
    private String historPhoto;//照片

    public History() {
    }

    public History(Integer historId, String historCarnumber, Date historStartime, Date historEndtime, Integer historMoney, String historPhoto) {
        this.historId = historId;
        this.historCarnumber = historCarnumber;
        this.historStartime = historStartime;
        this.historEndtime = historEndtime;
        this.historMoney = historMoney;
        this.historPhoto = historPhoto;
    }

    public Integer getHistorId() {
        return historId;
    }

    public void setHistorId(Integer historId) {
        this.historId = historId;
    }

    public String getHistorCarnumber() {
        return historCarnumber;
    }

    public void setHistorCarnumber(String historCarnumber) {
        this.historCarnumber = historCarnumber;
    }

    public Date getHistorStartime() {
        return historStartime;
    }

    public void setHistorStartime(Date historStartime) {
        this.historStartime = historStartime;
    }

    public Date getHistorEndtime() {
        return historEndtime;
    }

    public void setHistorEndtime(Date historEndtime) {
        this.historEndtime = historEndtime;
    }

    public Integer getHistorMoney() {
        return historMoney;
    }

    public void setHistorMoney(Integer historMoney) {
        this.historMoney = historMoney;
    }

    public String getHistorPhoto() {
        return historPhoto;
    }

    public void setHistorPhoto(String historPhoto) {
        this.historPhoto = historPhoto;
    }

    @Override
    public String toString() {
        return "History{" +
                "historId=" + historId +
                ", historCarnumber='" + historCarnumber + '\'' +
                ", historStartime=" + historStartime +
                ", historEndtime=" + historEndtime +
                ", historMoney=" + historMoney +
                ", historPhoto='" + historPhoto + '\'' +
                '}';
    }
}