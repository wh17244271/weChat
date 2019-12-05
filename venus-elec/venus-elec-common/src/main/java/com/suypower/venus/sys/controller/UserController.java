package com.suypower.venus.sys.controller;


import com.suypower.venus.elec.common.utils.Assert;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.sys.common.UserConstant;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 删除用户通过用户id
     * @param user
     * @return
     */
    @RequestMapping( "/delUsers" )
    @ResponseBody
    public VenusResponse<List<User> > delUsers(User user) {
        String[] userIds = user.getUserIds();
        Assert.isEmpty(userIds,"选择删除的用户id不能为空");
        user.setUserStatus(UserConstant.status_quit);
        boolean integer = userService.updateUserStatusByUserids(user);
        return new VenusResponse(VenusResponseHttpCode.OK, integer);
    }

    /**
     * 通过多个条件查找用户信息
     * @param user
     * @return
     */
    @RequestMapping( "/findUserList" )
    @ResponseBody
    public VenusResponse<List<User> > findUserList(User user) {
        List<User> userByUserIno = userService.findUserList(user);
        return new VenusResponse(VenusResponseHttpCode.OK, userByUserIno);
    }

    /**
     * 通过用户名查找用户信息
     * @param user
     * @return
     */
    @RequestMapping( "/findUser" )
    @ResponseBody
    public VenusResponse<User> findByUserName(User user) {
        String userName = user.getUserName();
        Assert.isEmpty(userName,"用户名不能为空");
        user = userService.findByUserName(userName);
        return new VenusResponse(VenusResponseHttpCode.OK, user);
    }

    /**
     * 更新用户信息通过用户id
     * @param user
     * @return
     */
    @RequestMapping( "/updateUserInfoByUserId" )
    @ResponseBody
    public VenusResponse updateUserInfoByUserId(User user) {
        Assert.isEmpty(String.valueOf(user.getUserId()),"用户id不能为空");

        boolean result = userService.updateUserInfoByUserId(user);
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    /**
     *新增用户
     * @param user
     * @return
     */
    @RequestMapping( "/addUser" )
    @ResponseBody
    public VenusResponse addUser(User user) {
        User byUserName = userService.findByUserName(user.getUserName());
        Assert.isNotNull(byUserName,"该用户名已存在");
        String userPhone = user.getUserPhone();
        Assert.rightPhone(userPhone,"手机格式不正确");
        boolean result = userService.addUser(user);
        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }



}
