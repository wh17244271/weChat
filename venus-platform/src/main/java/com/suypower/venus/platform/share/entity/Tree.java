package com.suypower.venus.platform.share.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-07-29 平台公共树
 */
public class Tree<N extends Node> {

    /**
     * 树是单根节点(JSON返回返回对象结构)
     */
    private boolean singleRoot;


    public List<N> nodes;

    public Tree(List<N> nodes){
        this.setNodes(nodes);
        this.setSingleRoot(false);
    }

    public Tree(N node){
        this.setNodes(Arrays.asList(node));
        this.setSingleRoot(true);
    }

    public Tree(){

    }

    public boolean isSingleRoot() {
        return singleRoot;
    }

    public void setSingleRoot(boolean singleRoot) {
        this.singleRoot = singleRoot;
    }

    public List<N> getNodes() {
        return nodes;
    }

    public void setNodes(List<N> nodes) {
        this.nodes = nodes;
    }

    public boolean addNode(String pNodeId,N nodes) {
       //
        return false;
    }

    public N getNode(String nodeId) {
        //
        return null;
    }

    public boolean removeNode(String nodeId) {
        //
        return false;
    }

    public boolean removeNode(N node) {
        //
        return false;
    }
}
