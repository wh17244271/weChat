package com.suypower.venus.app.kbs.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

import java.util.List;

/**
 * @auther:maofukai
 * @date:2019-08-20 知识库-文章分类
 */
public class KbsArticleCategory {
    /**
     * 文章分类标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long categoryId;
    /**
     * 文章上一级分类标识S
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long categoryPid;
    /**
     * 文章分类标题
     */
    private String categoryTitle;
    /**
     * 文章分类名称
     */
    private String categoryName;
    /**
     * 文章分类状态
     */
    private String categoryStatus;
    /**
     * 文章分类置顶
     */
    private String categoryTop;
    /**
     * 文章分类推荐
     */
    private String categoryRecommend;
    /**
     * 文章分类权重
     */
    private String categoryWeight;
    /**
     * 子分类
     */
    private List<KbsArticleCategory> children;
    /**
     * 当前分类下的文章
     */
    private List<KbsArticle> kbsArticles;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryPid() {
        return categoryPid;
    }

    public void setCategoryPid(Long categoryPid) {
        this.categoryPid = categoryPid;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(String categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryTop() {
        return categoryTop;
    }

    public void setCategoryTop(String categoryTop) {
        this.categoryTop = categoryTop;
    }

    public String getCategoryRecommend() {
        return categoryRecommend;
    }

    public void setCategoryRecommend(String categoryRecommend) {
        this.categoryRecommend = categoryRecommend;
    }

    public String getCategoryWeight() {
        return categoryWeight;
    }

    public void setCategoryWeight(String categoryWeight) {
        this.categoryWeight = categoryWeight;
    }

    public List<KbsArticleCategory> getChildren() {
        return children;
    }

    public void setChildren(List<KbsArticleCategory> children) {
        this.children = children;
    }

    public List<KbsArticle> getKbsArticles() {
        return kbsArticles;
    }

    public void setKbsArticles(List<KbsArticle> kbsArticles) {
        this.kbsArticles = kbsArticles;
    }
}
