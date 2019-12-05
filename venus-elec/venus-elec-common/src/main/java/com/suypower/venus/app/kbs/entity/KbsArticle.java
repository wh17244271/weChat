package com.suypower.venus.app.kbs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suypower.venus.elec.common.common.converter.LongToStringSerializer;

import java.time.LocalDateTime;

/**
 * @auther:maofukai
 * @date:2019-08-20 知识库-文章
 */
public class KbsArticle {
    /**
     * 文章标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long articleId;

    /**
     * 文章分类标识
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private Long categoryId;
    /**
     * 文章分类名称
     */
    private String categoryName;
    /**
     * 文章分类标题
     */
    private String categoryTitle;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章来源
     */
    private String articleSource;
    /**
     * 文章作者(多个人名用,隔开)
     */
    private String articleAuthor;
    /**
     * 文章发布时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime articlePublishTime;
    /**
     * 文章状态(0=禁用,1=正常)
     */
    private String articleStatus;
    /**
     * 文章置顶(0=不置顶,1=置顶)
     */
    private String articleTop;
    /**
     * 文章推荐(0=不推荐,1=推荐)
     */
    private String articleRecommend;
    /**
     * 文章权重可用于排序(按照权重倒序显示)
     */
    @JsonSerialize(using = LongToStringSerializer.class)
    private long   articleWeight;
    /**
     * 文章关键字
     */
    private String articleKeywords;
    /**
     * 文章标题样式
     */
    private String articleStyle;
    /**
     * 文章抓取来源
     */
    private String articleCrawlSource;
    /**
     * 文章抓取时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime articleCrawlTime;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public LocalDateTime getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(LocalDateTime articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public String getArticleTop() {
        return articleTop;
    }

    public void setArticleTop(String articleTop) {
        this.articleTop = articleTop;
    }

    public String getArticleRecommend() {
        return articleRecommend;
    }

    public void setArticleRecommend(String articleRecommend) {
        this.articleRecommend = articleRecommend;
    }

    public long getArticleWeight() {
        return articleWeight;
    }

    public void setArticleWeight(long articleWeight) {
        this.articleWeight = articleWeight;
    }

    public String getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    public String getArticleStyle() {
        return articleStyle;
    }

    public void setArticleStyle(String articleStyle) {
        this.articleStyle = articleStyle;
    }

    public String getArticleCrawlSource() {
        return articleCrawlSource;
    }

    public void setArticleCrawlSource(String articleCrawlSource) {
        this.articleCrawlSource = articleCrawlSource;
    }

    public LocalDateTime getArticleCrawlTime() {
        return articleCrawlTime;
    }

    public void setArticleCrawlTime(LocalDateTime articleCrawlTime) {
        this.articleCrawlTime = articleCrawlTime;
    }
}

