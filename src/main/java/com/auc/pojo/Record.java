package com.auc.pojo;

import java.util.Date;
/**
 * 会员充值明细表
 */
public class Record {
    private Integer recordId;  //主id
    private Integer personId;  //用户id
    private Integer produceId; //产品id
    private Date recordStartime; //产品开始时间
    private Date recordEndtime;  //产品结束时间
    private String produceName;//产品名称
    private String personName;//用户名

    public Record() {
    }

    public Record(Integer recordId, Integer personId, Integer produceId, Date recordStartime, Date recordEndtime, String produceName, String personName) {
        this.recordId = recordId;
        this.personId = personId;
        this.produceId = produceId;
        this.recordStartime = recordStartime;
        this.recordEndtime = recordEndtime;
        this.produceName = produceName;
        this.personName = personName;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public Date getRecordStartime() {
        return recordStartime;
    }

    public void setRecordStartime(Date recordStartime) {
        this.recordStartime = recordStartime;
    }

    public Date getRecordEndtime() {
        return recordEndtime;
    }

    public void setRecordEndtime(Date recordEndtime) {
        this.recordEndtime = recordEndtime;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", personId=" + personId +
                ", produceId=" + produceId +
                ", recordStartime=" + recordStartime +
                ", recordEndtime=" + recordEndtime +
                ", produceName='" + produceName + '\'' +
                ", personName='" + personName + '\'' +
                '}';
    }
}
