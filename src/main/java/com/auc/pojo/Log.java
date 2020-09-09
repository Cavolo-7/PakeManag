package com.auc.pojo;

import java.util.Date;

public class Log {
    private Integer logId;//id
    private String logEvent;//事件
    private Date logTime;//时间
    private String logWorker;//操作人

    public Log() {
    }

    public Log(Integer logId, String logEvent, Date logTime, String logWorker) {
        this.logId = logId;
        this.logEvent = logEvent;
        this.logTime = logTime;
        this.logWorker = logWorker;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getLogEvent() {
        return logEvent;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogWorker() {
        return logWorker;
    }

    public void setLogWorker(String logWorker) {
        this.logWorker = logWorker;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logEvent='" + logEvent + '\'' +
                ", logTime=" + logTime +
                ", logWorker='" + logWorker + '\'' +
                '}';
    }
}
