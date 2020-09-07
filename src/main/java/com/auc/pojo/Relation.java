package com.auc.pojo;

public class Relation {
    private Integer relationId;//权限id
    private Integer menuId;//菜单id
    private Integer roleId;//角色id


    public Relation() {
    }

    public Relation(Integer relationId, Integer menuId, Integer roleId) {
        this.relationId = relationId;
        this.menuId = menuId;
        this.roleId = roleId;
    }

    public Integer getRelationId() {
        return relationId;
    }

    public void setRelationId(Integer relationId) {
        this.relationId = relationId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relationId=" + relationId +
                ", menuId=" + menuId +
                ", roleId=" + roleId +
                '}';
    }
}
