package com.auc.pojo;

public class Param {
    private Integer paramId;//参数id
    private String paramName;//参数名字
    private String paramType;//参数类型
    private Integer paramValue;//参数值

    public Param() {
    }



    public Integer getParamValue() {
        return paramValue;
    }

    public void setParamValue(Integer paramValue) {
        this.paramValue = paramValue;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    @Override
    public String toString() {
        return "Param{" +
                "paramId=" + paramId +
                ", paramName='" + paramName + '\'' +
                ", paramType='" + paramType + '\'' +
                ", paramValue=" + paramValue +
                '}';
    }
}
