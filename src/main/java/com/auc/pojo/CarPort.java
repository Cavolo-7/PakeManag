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

    private Integer allPark;//总车位数
    private Integer employPark;//已用车位数
    private Integer leisurePark;//空闲车位数

    private Integer allSubarea;//分区总车位数
    private Integer subarEaemploy;//分区已用车位数
    private Integer subarLeisure;//分区空闲车位数
    public CarPort() {
    }

    public CarPort(Integer carportId, String carportArea, Integer carportNumber, String carportCarnumber, String carportPhoto, Date carportStarttime, Integer carportState, Integer allPark, Integer employPark, Integer leisurePark, Integer allSubarea, Integer subarEaemploy, Integer subarLeisure) {
        this.carportId = carportId;
        this.carportArea = carportArea;
        this.carportNumber = carportNumber;
        this.carportCarnumber = carportCarnumber;
        this.carportPhoto = carportPhoto;
        this.carportStarttime = carportStarttime;
        this.carportState = carportState;
        this.allPark = allPark;
        this.employPark = employPark;
        this.leisurePark = leisurePark;
        this.allSubarea = allSubarea;
        this.subarEaemploy = subarEaemploy;
        this.subarLeisure = subarLeisure;
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

    public Integer getAllPark() {
        return allPark;
    }

    public void setAllPark(Integer allPark) {
        this.allPark = allPark;
    }

    public Integer getEmployPark() {
        return employPark;
    }

    public void setEmployPark(Integer employPark) {
        this.employPark = employPark;
    }

    public Integer getLeisurePark() {
        return leisurePark;
    }

    public void setLeisurePark(Integer leisurePark) {
        this.leisurePark = leisurePark;
    }

    public Integer getAllSubarea() {
        return allSubarea;
    }

    public void setAllSubarea(Integer allSubarea) {
        this.allSubarea = allSubarea;
    }

    public Integer getSubarEaemploy() {
        return subarEaemploy;
    }

    public void setSubarEaemploy(Integer subarEaemploy) {
        this.subarEaemploy = subarEaemploy;
    }

    public Integer getSubarLeisure() {
        return subarLeisure;
    }

    public void setSubarLeisure(Integer subarLeisure) {
        this.subarLeisure = subarLeisure;
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
                ", allPark=" + allPark +
                ", employPark=" + employPark +
                ", leisurePark=" + leisurePark +
                ", allSubarea=" + allSubarea +
                ", subarEaemploy=" + subarEaemploy +
                ", subarLeisure=" + subarLeisure +
                '}';
    }
}