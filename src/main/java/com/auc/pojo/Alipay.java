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

    private Integer personId;//用户id
    private String personAccount;//用户账号
    private String personName;//用户姓名
    private String produceName;//月缴产品名称
    private Integer workerId;//操作人员id
    public Alipay() {
    }

    public Alipay(Integer alipayId, String alipayNumber, String alipayCarnumber) {
        this.alipayId = alipayId;
        this.alipayNumber = alipayNumber;
        this.alipayCarnumber = alipayCarnumber;
    }

    public Alipay(Integer alipayId, String alipayNumber, String alipayCarnumber, Integer personId, String personAccount, String personName, String produceName,Integer workerId) {
        this.alipayId = alipayId;
        this.alipayNumber = alipayNumber;
        this.alipayCarnumber = alipayCarnumber;
        this.personId = personId;
        this.personAccount = personAccount;
        this.personName = personName;
        this.produceName = produceName;
        this.workerId=workerId;
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(String personAccount) {
        this.personAccount = personAccount;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public String
    toString() {
        return "Alipay{" +
                "alipayId=" + alipayId +
                ", alipayNumber='" + alipayNumber + '\'' +
                ", alipayCarnumber='" + alipayCarnumber + '\'' +
                ", personId=" + personId +
                ", personAccount='" + personAccount + '\'' +
                ", personName='" + personName + '\'' +
                ", produceName='" + produceName + '\'' +
                ", workerId=" + workerId +
                '}';
    }
}