package com.suypower.venus.common;

public enum WebSocketGroup {
    chat_chatList("1","聊天","1","聊天列表");


    private String groupCode;
    private String groupName;
    private String typeCode;
    private String typeName;



    WebSocketGroup(String groupCode, String groupName, String typeCode, String typeName) {
        this.groupCode = groupCode;
        this.groupName = groupName;
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

/*
    public static Index parse(String groupCode) {
        WebSocketGroup find = null;
        WebSocketGroup[] indexes = values();
        for (WebSocketGroup index : indexes) {
            if (index.get().equals(value)) {
                find = index;
                break;
            }
        }
        return find;
    }

*/

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
