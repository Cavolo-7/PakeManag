package com.auc.pojo;

/**
 * @基本功能: 支付宝订单实体类
 * @program:ParkManage
 * @author:acsk
 * @create:2020-09-15 22:47:54
 **/
public class Alipay {

    private Integer alipayId;//订单id
    private String alipayNumber;//订单号
    private String alipayCarnumber;//车牌号

    public Alipay() {
    }

    public Alipay(Integer alipayId, String alipayNumber, String alipayCarnumber) {
        this.alipayId = alipayId;
        this.alipayNumber = alipayNumber;
        this.alipayCarnumber = alipayCarnumber;
    }

    public Integer getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(Integer alipayId) {
        this.alipayId = alipayId;
    }

    public String getAlipayNumber() {
        return alipayNumber;
    }

    public void setAlipayNumber(String alipayNumber) {
        this.alipayNumber = alipayNumber;
    }

    public String getAlipayCarnumber() {
        return alipayCarnumber;
    }

    public void setAlipayCarnumber(String alipayCarnumber) {
        this.alipayCarnumber = alipayCarnumber;
    }

    @Override
    public String toString() {
        return "Alipay{" +
                "alipayId=" + alipayId +
                ", alipayNumber='" + alipayNumber + '\'' +
                ", alipayCarnumber='" + alipayCarnumber + '\'' +
                '}';
    }
}