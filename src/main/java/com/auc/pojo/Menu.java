package com.auc.pojo;

import java.util.List;

public class Menu {
    private Integer menuId;//菜单Id
    private String menuName;//菜单名字
    private String menuUrl;//菜单路径
    private Integer parentId;//一级菜单
    private List<Menu> MenuList;
    public Menu() {
    }

    public Menu(Integer menuId, String menuName, String menuUrl, Integer parentId, List<Menu> menuList) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
        MenuList = menuList;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getMenuList() {
        return MenuList;
    }

    public void setMenuList(List<Menu> menuList) {
        MenuList = menuList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId=" + parentId +
                ", MenuList=" + MenuList +
                '}';
    }
}
