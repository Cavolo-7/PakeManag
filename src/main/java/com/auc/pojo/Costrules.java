package com.auc.pojo;
/**
 * 计费规则类
 */
public class Costrules {

    private Integer costrulesId;
    private String costrulesTime;
    private Integer costrulesMoney;
    private Integer costrulesState;
    private String paramName;//参数名字

    public Costrules() {
    }

    public Costrules(String costrulesTime, Integer costrulesMoney, Integer costrulesState) {
        this.costrulesTime = costrulesTime;
        this.costrulesMoney = costrulesMoney;
        this.costrulesState = costrulesState;
    }

    public Costrules(Integer costrulesId, String costrulesTime, Integer costrulesMoney, Integer costrulesState, String paramName) {
        this.costrulesId = costrulesId;
        this.costrulesTime = costrulesTime;
        this.costrulesMoney = costrulesMoney;
        this.costrulesState = costrulesState;
        this.paramName = paramName;
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

    public Integer getCostrulesId() {
        return costrulesId;
    }

    public void setCostrulesId(Integer costrulesId) {
        this.costrulesId = costrulesId;
    }

    public String getCostrulesTime() {
        return costrulesTime;
    }

    public void setCostrulesTime(String costrulesTime) {
        this.costrulesTime = costrulesTime;
    }

    public Integer getCostrulesMoney() {
        return costrulesMoney;
    }

    public void setCostrulesMoney(Integer costrulesMoney) {
        this.costrulesMoney = costrulesMoney;
    }


}
