package com.auc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @基本功能:
 * @program:FileShare
 * @author:acsk
 * @create:2020-08-29 13:42:22
 **/
public class TreeNode {

    private Integer id;//节点ID索引
    private String title;//节点显示标题
    private List<TreeNode> children = new ArrayList<>();//节点的子节点
    private boolean spread;//节点是否初始展开，默认 false
    private boolean checked;//节点是否初始为选中状态（如果开启复选框的话），默认 false

    public TreeNode() {
    }

    public TreeNode(Integer id, String title, List<TreeNode> children, boolean spread, boolean checked) {
        this.id = id;
        this.title = title;
        this.children = children;
        this.spread = spread;
        this.checked = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", children=" + children +
                ", spread=" + spread +
                ", checked=" + checked +
                '}';
    }
}