package com.auc.pojo;

/**
 * @基本功能:  广告实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-18 15:08:31
 **/
public class Advertise {

    private Integer advertiseId;//id
    private String advertiseImg;//图片路径

    public Advertise() {
    }

    public Advertise(Integer advertiseId, String advertiseImg) {
        this.advertiseId = advertiseId;
        this.advertiseImg = advertiseImg;
    }

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Integer advertiseId) {
        this.advertiseId = advertiseId;
    }

    public String getAdvertiseImg() {
        return advertiseImg;
    }

    public void setAdvertiseImg(String advertiseImg) {
        this.advertiseImg = advertiseImg;
    }

    @Override
    public String toString() {
        return "Advertise{" +
                "advertiseId=" + advertiseId +
                ", advertiseImg='" + advertiseImg + '\'' +
                '}';
    }
}