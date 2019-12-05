package com.suypower.venus.controller;

import com.alibaba.fastjson.JSONObject;
import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.entity.App;
import com.suypower.venus.entity.AppGroup;
import com.suypower.venus.entity.User;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserChatRoomManage;
import com.suypower.venus.utils.UserUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/api/set/user" )
public class SetUserController {

    /**
     * 置顶聊天
     * @param roomId
     * @param isTop
     * @return
     */
    @ResponseBody
    @RequestMapping( "/isTop" )
    public VenusResponse isTop(String roomId,boolean isTop) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        UserChatRoomManage.setTop(userId, roomId, isTop);
        return new VenusResponse(VenusResponseHttpCode.OK, "设置成功");
    }

    /**
     * 更改用户昵称
     * @param nickName
     * @return
     */
    @ResponseBody
    @RequestMapping( "/editNickName" )
    public VenusResponse editNickName(String nickName) {
        Assert.notNull(nickName,"用户昵称不能为null");
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        User userByUserId = UserUtils.getUserByUserId(userId);
        userByUserId.setNickname(nickName);
        return new VenusResponse(VenusResponseHttpCode.OK, "更改成功");
    }

    /**
     * 设置头像
     * @param headerUrl
     * @return
     */
    @ResponseBody
    @RequestMapping( "/editHeadPortrait" )
    public VenusResponse editHeadPortrait(String headerUrl) {
        Assert.notNull(headerUrl,"用户头像地址不能为null");
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        User userByUserId = UserUtils.getUserByUserId(userId);
        userByUserId.setHeaderUrl(headerUrl);
        return new VenusResponse(VenusResponseHttpCode.OK, "更改成功");
    }


}
