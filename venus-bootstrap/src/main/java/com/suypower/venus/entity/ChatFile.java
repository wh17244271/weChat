package com.suypower.venus.entity;

public class ChatFile {
    /**
     * 文件id
     */
    private String fileId;
    /**
     * 原文件名
     */
    private String fileOriName;
    /**
     * 文件后缀名
     */
    private String fileSuffix;
    /**
     *
     */
    private Long fileSize;
    /**
     * 文件保存路径
     */
    private String fileUrl;
    /**
     * 自己命名
     */
    private  String fileName;

    public ChatFile() {
    }

    public ChatFile(String fileId, String fileOriName, String fileSuffix, Long fileSize, String fileUrl, String fileName) {
        this.fileId = fileId;
        this.fileOriName = fileOriName;
        this.fileSuffix = fileSuffix;
        this.fileSize = fileSize;
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileOriName() {
        return fileOriName;
    }

    public void setFileOriName(String fileOriName) {
        this.fileOriName = fileOriName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
