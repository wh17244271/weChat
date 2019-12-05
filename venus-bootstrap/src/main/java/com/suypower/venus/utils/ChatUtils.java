package com.suypower.venus.utils;

public class ChatUtils {

    /**
     * 生成群聊名称
     * @param initName
     * @param number
     * @return
     */
    public static String getChatRoomName(String initName,int number){
        return initName+"("+number+")";
    }
}
