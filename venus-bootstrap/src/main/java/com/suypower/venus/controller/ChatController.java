package com.suypower.venus.controller;

import com.alibaba.fastjson.JSONObject;
import com.suypower.venus.common.ChatCommonMethod;
import com.suypower.venus.common.ConstantChatRoomType;
import com.suypower.venus.common.ConstantMsgType;
import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.entity.*;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.UserChatRoomManage;
import com.suypower.venus.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping( "/api/chat" )
public class ChatController extends BaseController {

    public static void main(String[] args) {
        long time = new Date().getTime();
        System.out.println(time);
    }

    static {
        ChatRoom lg2zg = new ChatRoom();
        lg2zg.setRoomId("100");
        lg2zg.setRoomType(ConstantChatRoomType.chat_type_friend);
        lg2zg.setMsg(new ArrayList<ChatMessage>() {{
            this.add(new ChatMessage("1", "lg", "zg", ConstantMsgType.text, "赵工、你好!看看这张图:", 1571812679000L, "100"));
            this.add(new ChatMessage("2", "lg", "zg", ConstantMsgType.img, "timg.gif", 1571812679000L, "100"));

            this.add(new ChatMessage("3", "zg", "lg", ConstantMsgType.text, "李工、你好！", 1571899079000L, "100"));
            this.add(new ChatMessage("4", "lg", "zg", ConstantMsgType.text, "今天几点上班？", new Date().getTime(), "100"));
            this.add(new ChatMessage("5", "zg", "lg", ConstantMsgType.text, "8:30上班", new Date().getTime(), "100"));
        }});

        ChatRoom lg2wg = new ChatRoom();
        lg2wg.setRoomId("101");
        lg2wg.setRoomType(ConstantChatRoomType.chat_type_friend);
        lg2wg.setMsg(new ArrayList<ChatMessage>() {{
            this.add(new ChatMessage("11", "lg", "wg", ConstantMsgType.text, "吴工、你好!", 1571812679001L, "101"));
            this.add(new ChatMessage("12", "wg", "lg", ConstantMsgType.text, "李工、你好！", 1571812679002L, "101"));
            this.add(new ChatMessage("13", "lg", "wg", ConstantMsgType.text, "今天几点上班？", 1571812679004L, "101"));
            this.add(new ChatMessage("14", "wg", "lg", ConstantMsgType.text, "8:35上班", new Date().getTime(), "101"));
        }});

        ChatRoom groupRoom = new ChatRoom();
        groupRoom.setRoomId("10086");
        groupRoom.setRoomType(ConstantChatRoomType.chat_type_group);
        groupRoom.setRoomName("穿越时空的聊天群");
        groupRoom.setMsg(new ArrayList<ChatMessage>() {{
            this.add(new ChatMessage("21", "lg", "", ConstantMsgType.text, "大家好，我是李世民", 1572486371000L, "10086"));
            this.add(new ChatMessage("22", "wg", "", ConstantMsgType.text, "我是吴三桂", 1571812679002L, "10086"));
            this.add(new ChatMessage("23", "lg", "", ConstantMsgType.text, "你清朝来的？", 1571812679004L, "10086"));
            this.add(new ChatMessage("24", "zg", "", ConstantMsgType.text, "哈哈，我是周润发", new Date().getTime(), "10086"));
        }});

        //-----------------------------------------------------------------------------------------------------------
        // 《李工》聊天管理
        UserChatRoomManage lgUserChatRoomManage = UserChatRoomManage.getOrCreate("lg");

        //李工跟赵工聊天
        UserChatRoom lg2zgChat = new UserChatRoom(UserUtils.getUserByUserId("lg"), lg2zg, 1572486371000L, false, false);
        lgUserChatRoomManage.addUserChatRoom(lg2zgChat);

        //李工跟吴工聊天
        UserChatRoom lg2wgChat = new UserChatRoom(UserUtils.getUserByUserId("lg"), lg2wg, 1572364800000L, true, false);
        lgUserChatRoomManage.addUserChatRoom(lg2wgChat);

        //李工的群聊   并且是群主
        UserChatRoom lgGroup = new UserChatRoom(UserUtils.getUserByUserId("lg"), groupRoom, 1572486371000L, true, true);
        lgUserChatRoomManage.addUserChatRoom(lgGroup);

        //-----------------------------------------------------------------------------------------------------------
        //《赵工》聊天管理
        UserChatRoomManage zgUserChatRoomManage = UserChatRoomManage.getOrCreate("zg");

        //赵工跟李工聊天
        UserChatRoom zg2lgChat = new UserChatRoom(UserUtils.getUserByUserId("zg"), lg2zg, new Date().getTime(), false, false);
        zgUserChatRoomManage.addUserChatRoom(zg2lgChat);
        //赵工的群聊
        UserChatRoom zgGroup = new UserChatRoom(UserUtils.getUserByUserId("zg"), groupRoom, new Date().getTime(), false, false);
//        zgGroup.setKickOut(false);
//        zgGroup.setKickOutTime(1571812679003L);
        zgUserChatRoomManage.addUserChatRoom(zgGroup);
        //-----------------------------------------------------------------------------------------------------------
        //《吴工》聊天管理
        UserChatRoomManage wgUserChatRoomManage = UserChatRoomManage.getOrCreate("wg");

        //吴工跟李工聊天
        UserChatRoom wg2lgChat = new UserChatRoom(UserUtils.getUserByUserId("wg"), lg2wg, new Date().getTime(), false, false);
        wgUserChatRoomManage.addUserChatRoom(wg2lgChat);
        //吴工群聊
        UserChatRoom gwGroup = new UserChatRoom(UserUtils.getUserByUserId("wg"), groupRoom, new Date().getTime(), false, false);
        wgUserChatRoomManage.addUserChatRoom(gwGroup);
    }

    /**
     * 获取当前登录人的聊天列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping( "/findChatList" )
    public VenusResponse findChatList() {
        String userId = String.valueOf(ServletUtils.getSessionAttribute(ConstantUser.login_user));
        List<ChatRoom> chatList = ChatCommonMethod.getChatList(userId);
        return new VenusResponse(VenusResponseHttpCode.OK, chatList);
    }

    /**
     * 获取当前登录人某个聊天室的聊天记录列表
     *
     * @param roomId
     * @return
     */
    @ResponseBody
    @RequestMapping( "/findChatData" )
    public VenusResponse findChatData(String roomId, String lastMsgId, Long limit) {
        ChatRoom chatRoom;

        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);

        List<ChatMessage> messageList = UserChatRoomManage.getChatMessageExceptDel(userId, roomId, lastMsgId, limit, true);
        String chatRoomType = UserChatRoomManage.getChatRoomType(userId, roomId);
        List<User> userList = UserChatRoomManage.getUserList(chatRoomType, roomId, userId);

        String chatRoomName = UserChatRoomManage.getChatRoomName(userId, roomId);
        ChatCommonMethod.getUserListRemark(userId, userList);

        chatRoom = new ChatRoom(roomId, chatRoomType, messageList, userList, userId, chatRoomName);
        return new VenusResponse(VenusResponseHttpCode.OK, chatRoom);

    }

    /**
     * 获取指定类型聊天记录
     * @param roomId
     * @param msgType
     * @return
     */
    @ResponseBody
    @RequestMapping( "/findChatRecord" )
    public VenusResponse findChatRecord(String roomId,String msgType) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        List<ChatMessage> chatRecord = UserChatRoomManage.getChatRecord(userId, roomId, msgType);
        return new VenusResponse(VenusResponseHttpCode.OK, chatRecord);
    }


    /**
     * 获取群消息
     *
     * @param roomId
     * @return
     */
    @ResponseBody
    @RequestMapping( "/findGroupInfo" )
    public VenusResponse findGroupInfo(String roomId) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        UserChatRoom userChatRoom = UserChatRoomManage.getUserChatRoom(userId, roomId);
        List<User> userList = UserChatRoomManage.getUserList(roomId);
        GroupInfo groupInfo = new GroupInfo(
                roomId, userChatRoom.isGroupOwner(), userChatRoom.getChatRoom().getRoomName(),
                userList, userChatRoom.isTop()
        );

        return new VenusResponse(VenusResponseHttpCode.OK, groupInfo);
    }


    /**
     * 删除聊天室
     *
     * @param roomId
     * @return
     */
    @ResponseBody
    @RequestMapping( "/delChatRoom" )
    public VenusResponse delChatRoom(String roomId) {
        String loginUserId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        boolean result = UserChatRoomManage.delChatRoom(loginUserId, roomId);
        if (result) {
            return new VenusResponse(VenusResponseHttpCode.OK, result);
        } else {
            return new VenusResponse(VenusResponseHttpCode.InternalServerError, result);
        }

    }

    /**
     * 创建新的聊天室
     *
     * @param toUserId
     * @param roomType 聊天室类型
     * @return
     */
    @ResponseBody
    @RequestMapping( "/creatChatRoom" )
    public VenusResponse creatChatRoom(String toUserId, String roomType) {
        String fromUserId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        String roomId = UserChatRoomManage.creatChatRoom(fromUserId, toUserId, roomType);
        JSONObject result = new JSONObject() {{
            this.put("roomId", roomId);
        }};
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    /**
     * 创建群聊
     *
     * @param pullers
     * @return
     */
    @ResponseBody
    @RequestMapping( "/creatGroupChatRoom" )
    public VenusResponse creatGroupChatRoom(String[] pullers) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        String roomId = UserChatRoomManage.creatGroupChatRoom(userId, pullers);
        JSONObject result = new JSONObject() {{
            this.put("roomId", roomId);
        }};
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    /**
     * 拉人进群
     *
     * @param roomId
     * @param pullers
     * @return
     */
    @ResponseBody
    @RequestMapping( "/pullToGroup" )
    public VenusResponse pullToGroup(String roomId, String[] pullers) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        UserChatRoomManage.pullToGroup(userId, roomId, pullers);
        return new VenusResponse(VenusResponseHttpCode.OK, "拉人成功");
    }


    /**
     * 删除某条消息(状态删除)
     *
     * @param roomId
     * @param msgIds
     * @return
     */
    @ResponseBody
    @RequestMapping( "/delChatData" )
    public VenusResponse delChatData(String roomId, String[] msgIds) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        UserChatRoomManage.delMessage(userId, roomId, msgIds);

        return new VenusResponse(VenusResponseHttpCode.OK, "修改成功");
    }


    @ResponseBody
    @RequestMapping( "/searchChatInfo" )
    public VenusResponse searchChatInfo(String roomId, String searchType) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
//        UserChatRoomManage.
        return null;
    }

}
