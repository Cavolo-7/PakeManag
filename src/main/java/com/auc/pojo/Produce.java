package com.auc.pojo;

public class Produce {
    /**
     * 月产品表实体类
     */
    private Integer produceId;//月缴产品id
    private String produceName;//月缴产品名称
    private String produceDescribe;//月缴产品描述
    private Integer produceMoney;//月缴产品价格

    public Produce() {
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getProduceDescribe() {
        return produceDescribe;
    }

    public void setProduceDescribe(String produceDescribe) {
        this.produceDescribe = produceDescribe;
    }

    public Integer getProduceMoney() {
        return produceMoney;
    }

    public void setProduceMoney(Integer produceMoney) {
        this.produceMoney = produceMoney;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "produceId=" + produceId +
                ", produceName='" + produceName + '\'' +
                ", produceDescribe='" + produceDescribe + '\'' +
                ", produceMoney=" + produceMoney +
                '}';
    }
}
