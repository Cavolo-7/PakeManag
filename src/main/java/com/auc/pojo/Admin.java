package com.auc.pojo;


import java.util.Date;

public class Admin {
   /**
    * 管理员表实体类
    */
   private Integer workerId;//员工表id
   private String workerAccount;//员工账号
   private String workerPassword;//员工密码n
   private String workerName;//用户名
   private Integer roleId;//角色id
   private Integer workerState;//员工账号状态
   private String workerPhone;//员工电话号码
   private String workerAge;//员工年龄
   private Integer workerSex;//员工性别
   private String workerAddress;//员工住址

   private String roleName;//角色名称
   private String stateName;//状态名称


   public Admin() {
   }

   public Admin(Integer workerId, String workerAccount, String workerPassword, String workerName, Integer roleId, Integer workerState, String workerPhone, String workerAge, Integer workerSex, String workerAddress) {
      this.workerId = workerId;
      this.workerAccount = workerAccount;
      this.workerPassword = workerPassword;
      this.workerName = workerName;
      this.roleId = roleId;
      this.workerState = workerState;
      this.workerPhone = workerPhone;
      this.workerAge = workerAge;
      this.workerSex = workerSex;
      this.workerAddress = workerAddress;
   }

   public Integer getWorkerId() {
      return workerId;
   }

   public void setWorkerId(Integer workerId) {
      this.workerId = workerId;
   }

   public String getWorkerAccount() {
      return workerAccount;
   }

   public void setWorkerAccount(String workerAccount) {
      this.workerAccount = workerAccount;
   }

   public String getWorkerPassword() {
      return workerPassword;
   }

   public void setWorkerPassword(String workerPassword) {
      this.workerPassword = workerPassword;
   }

   public String getWorkerName() {
      return workerName;
   }

   public void setWorkerName(String workerName) {
      this.workerName = workerName;
   }

   public Integer getRoleId() {
      return roleId;
   }

   public void setRoleId(Integer roleId) {
      this.roleId = roleId;
   }

   public Integer getWorkerState() {
      return workerState;
   }

   public void setWorkerState(Integer workerState) {
      this.workerState = workerState;
   }

   public String getWorkerPhone() {
      return workerPhone;
   }

   public void setWorkerPhone(String workerPhone) {
      this.workerPhone = workerPhone;
   }

   public String getWorkerAge() {
      return workerAge;
   }

   public void setWorkerAge(String workerAge) {
      this.workerAge = workerAge;
   }

   public Integer getWorkerSex() {
      return workerSex;
   }

   public void setWorkerSex(Integer workerSex) {
      this.workerSex = workerSex;
   }

   public String getWorkerAddress() {
      return workerAddress;
   }

   public void setWorkerAddress(String workerAddress) {
      this.workerAddress = workerAddress;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }

   public String getStateName() {
      return stateName;
   }

   public void setStateName(String stateName) {
      this.stateName = stateName;
   }

   @Override
   public String toString() {
      return "Admin{" +
              "workerId=" + workerId +
              ", workerAccount='" + workerAccount + '\'' +
              ", workerPassword='" + workerPassword + '\'' +
              ", workerName='" + workerName + '\'' +
              ", roleId=" + roleId +
              ", workerState=" + workerState +
              ", workerPhone='" + workerPhone + '\'' +
              ", workerAge='" + workerAge + '\'' +
              ", workerSex=" + workerSex +
              ", workerAddress='" + workerAddress + '\'' +
              ", roleName='" + roleName + '\'' +
              ", stateName='" + stateName + '\'' +
              '}';
   }
}