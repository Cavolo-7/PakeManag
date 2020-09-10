package com.auc.pojo;

public class Role {
    private Integer roleId;//角色id
    private String roleName;//角色名字
    private Integer urisdictionId;//权限id
    private Integer roleState;//权限id
    private String urisdictionName;//权限名

    public Role() {
    }

    public Role(Integer roleId, String roleName, Integer urisdictionId, Integer roleState, String urisdictionName) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.urisdictionId = urisdictionId;
        this.roleState = roleState;
        this.urisdictionName = urisdictionName;
    }

    public Integer getRoleState() {
        return roleState;
    }

    public void setRoleState(Integer roleState) {
        this.roleState = roleState;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUrisdictionId() {
        return urisdictionId;
    }

    public void setUrisdictionId(Integer urisdictionId) {
        this.urisdictionId = urisdictionId;
    }

    public String getUrisdictionName() {
        return urisdictionName;
    }

    public void setUrisdictionName(String urisdictionName) {
        this.urisdictionName = urisdictionName;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", urisdictionId=" + urisdictionId +
                ", roleState=" + roleState +
                ", urisdictionName='" + urisdictionName + '\'' +
                '}';
    }
}
