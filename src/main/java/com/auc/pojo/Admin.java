package com.auc.pojo;

import org.springframework.lang.Nullable;

import java.util.Date;

public class Admin {

    private String vipAccount;
    private String vipPassword;



    public Admin() {
    }


    public Admin(String vipAccount, String vipPassword) {
        this.vipAccount = vipAccount;
        this.vipPassword = vipPassword;
    }

    public String getVipAccount() {
        return vipAccount;
    }

    public void setVipAccount(String vipAccount) {
        this.vipAccount = vipAccount;
    }

    public String getVipPassword() {
        return vipPassword;
    }

    public void setVipPassword(String vipPassword) {
        this.vipPassword = vipPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "vipAccount='" + vipAccount + '\'' +
                ", vipPasswords='" + vipPassword + '\'' +
                '}';
    }
}