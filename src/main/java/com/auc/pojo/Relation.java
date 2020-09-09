package com.auc.pojo;

public class Relation {
    private Integer relationId;//关系id
    private Integer menuId;//菜单id
    private Integer urisdictionId;//权限id


    public Relation() {
    }

    public Relation(Integer relationId, Integer menuId, Integer urisdictionId) {
        this.relationId = relationId;
        this.menuId = menuId;
        this.urisdictionId = urisdictionId;
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

    public Integer getUrisdictionId() {
        return urisdictionId;
    }

    public void setUrisdictionId(Integer urisdictionId) {
        this.urisdictionId = urisdictionId;
    }


    @Override
    public String toString() {
        return "Relation{" +
                "relationId=" + relationId +
                ", menuId=" + menuId +
                ", urisdictionId=" + urisdictionId +
                '}';
    }
}
