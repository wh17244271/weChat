package com.suypower.venus.webSocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suypower.venus.entity.ChatMessage;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserUtils;

import java.util.Date;

public class SocketUtils {


    public static ChatMessage formatMsg(String message) {
        ChatMessage chatMessage = new ChatMessage();
        try {
            JSONObject jsonObject = JSON.parseObject(message);
            //需要后台生成的字段
            chatMessage.setId(StringUtils.uuid());
            chatMessage.setTime(new Date().getTime());

            //发送人
            String fromUserId = jsonObject.getString("from");
            chatMessage.setFrom(fromUserId);
            //接收人
            String toUserId = jsonObject.getString("to");
            chatMessage.setTo(toUserId);
            //消息类型
            String msgType = jsonObject.getString("msgType");
            chatMessage.setMsgType(msgType);
            //消息内容
            Object msg = jsonObject.getString("msg");
            chatMessage.setMsg(msg);
            //聊天室
            String roomId = jsonObject.getString("roomId");
            chatMessage.setRoomId(roomId);
            //数据分组
            String dataGroup = jsonObject.getString("dataGroup");
            chatMessage.setDataGroup(dataGroup);
            // 数据类型
            String dataType = jsonObject.getString("dataType");
            chatMessage.setDataType(dataType);
            //用户User
            chatMessage.setUser(UserUtils.getUserByUserId(fromUserId));
            //文件相关格式
            String fileUrl = jsonObject.getString("fileUrl");
            String fileSize = jsonObject.getString("fileSize");
            String fileName = jsonObject.getString("fileName");
            String fileOriName = jsonObject.getString("fileOriName");
            String fileSuffix = jsonObject.getString("fileSuffix");
            chatMessage.setFileUrl(fileUrl);
            chatMessage.setFileOriName(fileOriName);
            chatMessage.setFileName(fileName);
            chatMessage.setFileSize(fileSize);
            chatMessage.setFileSuffix(fileSuffix);
            //拉人聊天
            String pullers = jsonObject.getString("pullers");
            chatMessage.setPullers(pullers);
            //踢人聊天
            String kickers = jsonObject.getString("kickers");
            chatMessage.setKickers(kickers);

        } catch (Exception e) {
            throw new RuntimeException("socket解析格式错误!");
        }
        return chatMessage;
    }

    public static void main(String[] args) {
        String[] a = {"a","b"};
        JSONArray array = new JSONArray();
        array.add("w");
        array.add("h");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a",array);
        String[] pullers = (String[])jsonObject.get("a");
        System.out.println(pullers[0]);
    }
}
