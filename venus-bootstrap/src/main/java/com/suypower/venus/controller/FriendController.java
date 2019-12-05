package com.suypower.venus.controller;

import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.entity.Friend;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.FriendManage;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping( "/api/friend" )
public class FriendController {

   /* static {
        //---------------------------------------  lg  --------------------------------------------------------------------
        List<Friend> lgFriendList = new ArrayList<Friend>();
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("zg"), "周老三"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("wg"), "老吴"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("yg"), "应大"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("hg"), "老好人"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("qg"), "老钱"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("sg"), "猴子"));
        lgFriendList.add(new Friend(UserUtils.getUserByUserId("xg"), "老西"));
        FriendManage.addFriendList("lg", lgFriendList);
        //---------------------------------------  zg --------------------------------------------------------------------
        List<Friend> zgFriendList = new ArrayList<Friend>();
        zgFriendList.add(new Friend(UserUtils.getUserByUserId("lg"), "老李"));
        zgFriendList.add(new Friend(UserUtils.getUserByUserId("wg"), "小吴"));
        FriendManage.addFriendList("zg", zgFriendList);
        //---------------------------------------  wg --------------------------------------------------------------------
        List<Friend> wgFriendList = new ArrayList<Friend>();
        wgFriendList.add(new Friend(UserUtils.getUserByUserId("lg"), "老李"));
        wgFriendList.add(new Friend(UserUtils.getUserByUserId("zg"), "老周"));
        FriendManage.addFriendList("wg", wgFriendList);

    }*/


    /**
     * 获取好友列表
     *
     * @return
     */
    @ResponseBody
    @RequestMapping( "/getFriendList" )
    public VenusResponse getFriendList() {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        Set<Friend> friendList = FriendManage.getFriendList(userId);
        return new VenusResponse(VenusResponseHttpCode.OK, friendList);


    }

    /**
     * 修改好友备注
     *
     * @param friendUserId
     * @param friendRemark
     * @return
     */
    @ResponseBody
    @RequestMapping( "/editFriendRemark" )
    public VenusResponse editFriendRemark(String friendUserId, String friendRemark) {
        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        boolean b = FriendManage.editFriendRemark(userId, friendUserId, friendRemark);
        if (b) {
            return new VenusResponse(VenusResponseHttpCode.OK, "修改好友备注成功");
        } else {
            return new VenusResponse(VenusResponseHttpCode.InternalServerError, "修改好友备注失败");
        }

    }

    /**
     * 添加好友
     *
     * @param friendUserId
     * @return
     */
    @ResponseBody
    @RequestMapping( "/addFriend" )
    public VenusResponse addFriend(String friendUserId) {
        if (StringUtils.isEmpty(friendUserId)) {
            return new VenusResponse(VenusResponseHttpCode.InternalServerError, " friendUserId 不能为空");
        }

        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        FriendManage.addFriend(userId, friendUserId);
        FriendManage.addFriend(friendUserId, userId);
        return new VenusResponse(VenusResponseHttpCode.OK, "添加好友成功");
    }




}
