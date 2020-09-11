package com.auc.pojo;

import java.util.Date;
/**
 * 用户表实体类
 */
public class Person {

    private Integer personId;//用户表id
    private String personName;//用户名
    private String personAccount;//账号
    private String personPassword;//密码
    private String personCarnumber;//车牌号
    private Integer personSex;//用户性别
    private Integer personAge;//用户年龄
    private String personPhone;//用户电话号码
    private String personAddress;//用户住址
    private Integer personRecharge;//用户历史消费记录
    private Integer personScore;//用户积分
    private Integer personIdentity;//什么类型的会员
    private Integer workerId;//办理产品工作人员id
    private String workerName; //办理产品工作人员姓名
    private String sexName;//性别名称

    public Person() {
    }

    public Person(Integer personId, String personName, String personAccount, String personPassword, String personCarnumber, Integer personSex, Integer personAge, String personPhone, String personAddress, Integer personRecharge, Integer personScore, Integer personIdentity, Integer workerId, String workerName, String sexName) {
        this.personId = personId;
        this.personName = personName;
        this.personAccount = personAccount;
        this.personPassword = personPassword;
        this.personCarnumber = personCarnumber;
        this.personSex = personSex;
        this.personAge = personAge;
        this.personPhone = personPhone;
        this.personAddress = personAddress;
        this.personRecharge = personRecharge;
        this.personScore = personScore;
        this.personIdentity = personIdentity;
        this.workerId = workerId;
        this.workerName = workerName;
        this.sexName = sexName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(String personAccount) {
        this.personAccount = personAccount;
    }

    public String getPersonPassword() {
        return personPassword;
    }

    public void setPersonPassword(String personPassword) {
        this.personPassword = personPassword;
    }

    public String getPersonCarnumber() {
        return personCarnumber;
    }

    public void setPersonCarnumber(String personCarnumber) {
        this.personCarnumber = personCarnumber;
    }

    public Integer getPersonSex() {
        return personSex;
    }

    public void setPersonSex(Integer personSex) {
        this.personSex = personSex;
    }

    public Integer getPersonAge() {
        return personAge;
    }

    public void setPersonAge(Integer personAge) {
        this.personAge = personAge;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public Integer getPersonRecharge() {
        return personRecharge;
    }

    public void setPersonRecharge(Integer personRecharge) {
        this.personRecharge = personRecharge;
    }

    public Integer getPersonScore() {
        return personScore;
    }

    public void setPersonScore(Integer personScore) {
        this.personScore = personScore;
    }

    public Integer getPersonIdentity() {
        return personIdentity;
    }

    public void setPersonIdentity(Integer personIdentity) {
        this.personIdentity = personIdentity;
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

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personAccount='" + personAccount + '\'' +
                ", personPassword='" + personPassword + '\'' +
                ", personCarnumber='" + personCarnumber + '\'' +
                ", personSex=" + personSex +
                ", personAge=" + personAge +
                ", personPhone='" + personPhone + '\'' +
                ", personAddress='" + personAddress + '\'' +
                ", personRecharge=" + personRecharge +
                ", personScore=" + personScore +
                ", personIdentity=" + personIdentity +
                ", workerId=" + workerId +
                ", workerName='" + workerName + '\'' +
                ", sexName='" + sexName + '\'' +
                '}';
    }
}
