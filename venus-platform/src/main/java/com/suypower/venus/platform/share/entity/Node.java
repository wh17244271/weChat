package com.suypower.venus.platform.share.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-29 平台公共树节点
 */
public class Node {

    /**
     * 节点唯一标识
     */
    private String nodeId;
    /**
     * 节点标题
     */
    private String title;

    /**
     * 是否展开
     */
    private boolean expand;

    /**
     * 是否禁用checkbox功能
     */
    private boolean disableCheckbox;
    /**
     * 禁掉响应 true|false
     */
    private boolean disabled;

    /**
     * 节点是否被选中
     */
    private boolean selected;

    /**
     * 节点是否被勾选
     */
    private boolean checked;

    /**
     * 子节点
     */
    private List<Node> children;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isDisableCheckbox() {
        return disableCheckbox;
    }

    public void setDisableCheckbox(boolean disableCheckbox) {
        this.disableCheckbox = disableCheckbox;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public boolean addChild(Node child) {
        if(this.children==null){
            this.children = new ArrayList<>();
        }
        return this.children.add(child);
    }

    public boolean removeChild(Node child) {
        return this.children!=null ?
                this.children.remove(child)
                :
                true;
    }

    public boolean hasChild() {
        return this.children!=null ?
                this.children.size()>0
                :
                false;

    }
}
