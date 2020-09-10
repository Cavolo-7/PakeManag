package com.auc.pojo;
/**
 * 计费规则类
 */
public class Costrules {

    private Integer costrulesId;
    private String costrulesName;
    private Float costrulesMin;
    private Float costrulesMax;
    private String costrulesDescribe;
    private Integer costrulesBasemoney;
    private Integer costrulesAddmoney;
    private Integer costrulesState;
    private String paramName;//参数名字

    public Costrules() {
    }


    public Costrules(String costrulesName, Float costrulesMin, Float costrulesMax, String costrulesDescribe, Integer costrulesBasemoney, Integer costrulesAddmoney, Integer costrulesState) {
        this.costrulesName = costrulesName;
        this.costrulesMin = costrulesMin;
        this.costrulesMax = costrulesMax;
        this.costrulesDescribe = costrulesDescribe;
        this.costrulesBasemoney = costrulesBasemoney;
        this.costrulesAddmoney = costrulesAddmoney;
        this.costrulesState = costrulesState;
    }

    public Costrules(String costrulesName, Float costrulesMin, String costrulesDescribe, Integer costrulesBasemoney, Integer costrulesAddmoney, Integer costrulesState) {
        this.costrulesName = costrulesName;
        this.costrulesMin = costrulesMin;
        this.costrulesDescribe = costrulesDescribe;
        this.costrulesBasemoney = costrulesBasemoney;
        this.costrulesAddmoney = costrulesAddmoney;
        this.costrulesState = costrulesState;
    }

    public Costrules(Integer costrulesId, String costrulesName, Float costrulesMin, Float costrulesMax, String costrulesDescribe, Integer costrulesBasemoney, Integer costrulesAddmoney, Integer costrulesState, String paramName) {
        this.costrulesId = costrulesId;
        this.costrulesName = costrulesName;
        this.costrulesMin = costrulesMin;
        this.costrulesMax = costrulesMax;
        this.costrulesDescribe = costrulesDescribe;
        this.costrulesBasemoney = costrulesBasemoney;
        this.costrulesAddmoney = costrulesAddmoney;
        this.costrulesState = costrulesState;
        this.paramName = paramName;
    }

    public Integer getCostrulesId() {
        return costrulesId;
    }

    public void setCostrulesId(Integer costrulesId) {
        this.costrulesId = costrulesId;
    }

    public String getCostrulesName() {
        return costrulesName;
    }

    public void setCostrulesName(String costrulesName) {
        this.costrulesName = costrulesName;
    }

    public Float getCostrulesMin() {
        return costrulesMin;
    }

    public void setCostrulesMin(Float costrulesMin) {
        this.costrulesMin = costrulesMin;
    }

    public Float getCostrulesMax() {
        return costrulesMax;
    }

    public void setCostrulesMax(Float costrulesMax) {
        this.costrulesMax = costrulesMax;
    }

    public String getCostrulesDescribe() {
        return costrulesDescribe;
    }

    public void setCostrulesDescribe(String costrulesDescribe) {
        this.costrulesDescribe = costrulesDescribe;
    }

    public Integer getCostrulesBasemoney() {
        return costrulesBasemoney;
    }

    public void setCostrulesBasemoney(Integer costrulesBasemoney) {
        this.costrulesBasemoney = costrulesBasemoney;
    }

    public Integer getCostrulesAddmoney() {
        return costrulesAddmoney;
    }

    public void setCostrulesAddmoney(Integer costrulesAddmoney) {
        this.costrulesAddmoney = costrulesAddmoney;
    }

    public Integer getCostrulesState() {
        return costrulesState;
    }

    public void setCostrulesState(Integer costrulesState) {
        this.costrulesState = costrulesState;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String toString() {
        return "Costrules{" +
                "costrulesId=" + costrulesId +
                ", costrulesName='" + costrulesName + '\'' +
                ", costrulesMin='" + costrulesMin + '\'' +
                ", costrulesMax='" + costrulesMax + '\'' +
                ", costrulesDescribe='" + costrulesDescribe + '\'' +
                ", costrulesBasemoney=" + costrulesBasemoney +
                ", costrulesAddmoney=" + costrulesAddmoney +
                ", costrulesState=" + costrulesState +
                ", paramName='" + paramName + '\'' +
                '}';
    }
}
