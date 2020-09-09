package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能:  历史记录实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 15:54:21
 **/
public class History {

    private Integer historyId;//历史记录id
    private String historyCarnumber;//车牌号
    private Date historyStartime;//开始停车时间
    private Date historyEndtime;//结束时间
    private Integer historyMoney;//费用
    private String historyPhoto;//照片

    public History() {
    }

    public History(Integer historyId, String historyCarnumber, Date historyStartime, Date historyEndtime, Integer historyMoney, String historyPhoto) {
        this.historyId = historyId;
        this.historyCarnumber = historyCarnumber;
        this.historyStartime = historyStartime;
        this.historyEndtime = historyEndtime;
        this.historyMoney = historyMoney;
        this.historyPhoto = historyPhoto;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getHistoryCarnumber() {
        return historyCarnumber;
    }

    public void setHistoryCarnumber(String historyCarnumber) {
        this.historyCarnumber = historyCarnumber;
    }

    public Date getHistoryStartime() {
        return historyStartime;
    }

    public void setHistoryStartime(Date historyStartime) {
        this.historyStartime = historyStartime;
    }

    public Date getHistoryEndtime() {
        return historyEndtime;
    }

    public void setHistoryEndtime(Date historyEndtime) {
        this.historyEndtime = historyEndtime;
    }

    public Integer getHistoryMoney() {
        return historyMoney;
    }

    public void setHistoryMoney(Integer historyMoney) {
        this.historyMoney = historyMoney;
    }

    public String getHistoryPhoto() {
        return historyPhoto;
    }

    public void setHistoryPhoto(String historyPhoto) {
        this.historyPhoto = historyPhoto;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId=" + historyId +
                ", historyCarnumber='" + historyCarnumber + '\'' +
                ", historyStartime=" + historyStartime +
                ", historyEndtime=" + historyEndtime +
                ", historyMoney=" + historyMoney +
                ", historyPhoto='" + historyPhoto + '\'' +
                '}';
    }
}