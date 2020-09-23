package com.auc.pojo;
/**
 * 收支明细类
 */
public class Detail {
    private Integer detailId;
    private String detailCarnumber;
    private String detailEvent;
    private Integer produceId;
    private String detailTime;
    private Integer detailMoney;
    private Integer workerId;
    private String workerName;
    private String detailType; //支付类型

    private Integer countYear;//年份
    private Integer countMonth;//月份

    public Detail() {
    }

    public Detail(Integer detailId, String detailCarnumber, String detailEvent, Integer produceId, String detailTime, Integer detailMoney, Integer workerId, String workerName, String detailType) {
        this.detailId = detailId;
        this.detailCarnumber = detailCarnumber;
        this.detailEvent = detailEvent;
        this.produceId = produceId;
        this.detailTime = detailTime;
        this.detailMoney = detailMoney;
        this.workerId = workerId;
        this.workerName = workerName;
        this.detailType = detailType;
    }

    public Detail(Integer detailId, String detailCarnumber, String detailEvent, Integer produceId, String detailTime, Integer detailMoney, Integer workerId, String workerName, String detailType, Integer countYear, Integer countMonth) {
        this.detailId = detailId;
        this.detailCarnumber = detailCarnumber;
        this.detailEvent = detailEvent;
        this.produceId = produceId;
        this.detailTime = detailTime;
        this.detailMoney = detailMoney;
        this.workerId = workerId;
        this.workerName = workerName;
        this.detailType = detailType;
        this.countYear = countYear;
        this.countMonth = countMonth;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public String getDetailCarnumber() {
        return detailCarnumber;
    }

    public void setDetailCarnumber(String detailCarnumber) {
        this.detailCarnumber = detailCarnumber;
    }

    public String getDetailEvent() {
        return detailEvent;
    }

    public void setDetailEvent(String detailEvent) {
        this.detailEvent = detailEvent;
    }

    public Integer getProduceId() {
        return produceId;
    }

    public void setProduceId(Integer produceId) {
        this.produceId = produceId;
    }

    public String getDetailTime() {
        return detailTime;
    }

    public void setDetailTime(String detailTime) {
        this.detailTime = detailTime;
    }

    public Integer getDetailMoney() {
        return detailMoney;
    }

    public void setDetailMoney(Integer detailMoney) {
        this.detailMoney = detailMoney;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    public Integer getCountYear() {
        return countYear;
    }

    public void setCountYear(Integer countYear) {
        this.countYear = countYear;
    }

    public Integer getCountMonth() {
        return countMonth;
    }

    public void setCountMonth(Integer countMonth) {
        this.countMonth = countMonth;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailId=" + detailId +
                ", detailCarnumber='" + detailCarnumber + '\'' +
                ", detailEvent='" + detailEvent + '\'' +
                ", produceId=" + produceId +
                ", detailTime='" + detailTime + '\'' +
                ", detailMoney=" + detailMoney +
                ", workerId=" + workerId +
                ", workerName='" + workerName + '\'' +
                ", detailType='" + detailType + '\'' +
                ", countYear=" + countYear +
                ", countMonth=" + countMonth +
                '}';
    }
}
