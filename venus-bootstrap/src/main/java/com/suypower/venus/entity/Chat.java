package com.suypower.venus.entity;

public class Chat {
    private String id;
    private String showName;
    private String lastMsg;
    private String ico;
    private String top;

    public Chat() {
    }

    public Chat(String id, String showName, String lastMsg, String ico, String top) {
        this.id = id;
        this.showName = showName;
        this.lastMsg = lastMsg;
        this.ico = ico;
        this.top = top;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }
}
