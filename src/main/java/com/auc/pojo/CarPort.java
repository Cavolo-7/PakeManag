package com.auc.pojo;

import java.util.Date;

/**
 * @基本功能:  停车场车位实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-08 15:09:06
 **/
public class CarPort {
    private Integer carportId;//车位id
    private String carportArea;//区位
    private Integer carportNumber;//车位编号
    private String carportCarnumber;//车牌号
    private String carportPhoto;//车辆照片路径（入场所拍摄）
    private Date carportStarttime;//入场时间
    private Integer carportState;//车位状态（考虑后期预约停车）

    public CarPort() {
    }

    public CarPort(Integer carportId, String carportArea, Integer carportNumber, String carportCarnumber, String carportPhoto, Date carportStarttime, Integer carportState) {
        this.carportId = carportId;
        this.carportArea = carportArea;
        this.carportNumber = carportNumber;
        this.carportCarnumber = carportCarnumber;
        this.carportPhoto = carportPhoto;
        this.carportStarttime = carportStarttime;
        this.carportState = carportState;
    }

    public Integer getCarportId() {
        return carportId;
    }

    public void setCarportId(Integer carportId) {
        this.carportId = carportId;
    }

    public String getCarportArea() {
        return carportArea;
    }

    public void setCarportArea(String carportArea) {
        this.carportArea = carportArea;
    }

    public Integer getCarportNumber() {
        return carportNumber;
    }

    public void setCarportNumber(Integer carportNumber) {
        this.carportNumber = carportNumber;
    }

    public String getCarportCarnumber() {
        return carportCarnumber;
    }

    public void setCarportCarnumber(String carportCarnumber) {
        this.carportCarnumber = carportCarnumber;
    }

    public String getCarportPhoto() {
        return carportPhoto;
    }

    public void setCarportPhoto(String carportPhoto) {
        this.carportPhoto = carportPhoto;
    }

    public Date getCarportStarttime() {
        return carportStarttime;
    }

    public void setCarportStarttime(Date carportStarttime) {
        this.carportStarttime = carportStarttime;
    }

    public Integer getCarportState() {
        return carportState;
    }

    public void setCarportState(Integer carportState) {
        this.carportState = carportState;
    }

    @Override
    public String toString() {
        return "CarPort{" +
                "carportId=" + carportId +
                ", carportArea='" + carportArea + '\'' +
                ", carportNumber=" + carportNumber +
                ", carportCarnumber='" + carportCarnumber + '\'' +
                ", carportPhoto='" + carportPhoto + '\'' +
                ", carportStarttime=" + carportStarttime +
                ", carportState=" + carportState +
                '}';
    }
}