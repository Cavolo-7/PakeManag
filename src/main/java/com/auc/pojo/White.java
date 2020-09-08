package com.auc.pojo;

import java.util.Date;

public class White {
    private Integer whiteId;  //id
    private String whiteName;
    private String whiteAccount;
    private String whitePassword;
    private String whiteCarnumber;
    private String whitePhone;
    private Date whiteCreatetime;
    private Integer workerId;
    private String workerName;

    public White() {
    }

    public White(Integer whiteId, String whiteName, String whiteAccount, String whitePassword, String whiteCarnumber, String whitePhone, Date whiteCreatetime, Integer workerId, String workerName) {
        this.whiteId = whiteId;
        this.whiteName = whiteName;
        this.whiteAccount = whiteAccount;
        this.whitePassword = whitePassword;
        this.whiteCarnumber = whiteCarnumber;
        this.whitePhone = whitePhone;
        this.whiteCreatetime = whiteCreatetime;
        this.workerId = workerId;
        this.workerName = workerName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWhiteAccount() {
        return whiteAccount;
    }

    public void setWhiteAccount(String whiteAccount) {
        this.whiteAccount = whiteAccount;
    }

    public String getWhitePassword() {
        return whitePassword;
    }

    public void setWhitePassword(String whitePassword) {
        this.whitePassword = whitePassword;
    }

    public Integer getWhiteId() {
        return whiteId;
    }

    public void setWhiteId(Integer whiteId) {
        this.whiteId = whiteId;
    }

    public String getWhiteName() {
        return whiteName;
    }

    public void setWhiteName(String whiteName) {
        this.whiteName = whiteName;
    }

    public String getWhiteCarnumber() {
        return whiteCarnumber;
    }

    public void setWhiteCarnumber(String whiteCarnumber) {
        this.whiteCarnumber = whiteCarnumber;
    }

    public String getWhitePhone() {
        return whitePhone;
    }

    public void setWhitePhone(String whitePhone) {
        this.whitePhone = whitePhone;
    }

    public Date getWhiteCreatetime() {
        return whiteCreatetime;
    }

    public void setWhiteCreatetime(Date whiteCreatetime) {
        this.whiteCreatetime = whiteCreatetime;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    @Override
    public String toString() {
        return "White{" +
                "whiteId=" + whiteId +
                ", whiteName='" + whiteName + '\'' +
                ", whiteAccount='" + whiteAccount + '\'' +
                ", whitePassword='" + whitePassword + '\'' +
                ", whiteCarnumber='" + whiteCarnumber + '\'' +
                ", whitePhone='" + whitePhone + '\'' +
                ", whiteCreatetime=" + whiteCreatetime +
                ", workerId=" + workerId +
                ", workerName='" + workerName + '\'' +
                '}';
    }
}
