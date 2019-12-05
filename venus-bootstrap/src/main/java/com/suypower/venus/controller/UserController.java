package com.suypower.venus.controller;

import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.entity.Friend;
import com.suypower.venus.entity.User;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.FriendManage;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.StringUtils;
import com.suypower.venus.utils.UserUtils;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping( "/api/user" )
public class UserController {
    public static List<User> users = new ArrayList<User>();
    static {
        users.add(new User("yg", "yg", "123456", "应工","s", "/file/user/yg/head/zhugeliang.jpg", 1, "/wechat","女","一想到你以后会和别人亲亲抱抱滚床单我就巴不得你死掉","江苏,南京"));
        users.add(new User("lg", "lg", "123456", "李工","l", "/file/user/lg/head/pkq.gif", 1, "/wechat","男","好好去爱，去生活。记住，每天的太阳都是新的，不要辜负了美好的晨光","江苏,苏州"));
        users.add(new User("wg", "wg", "123456", "吴工", "w","/file/user/wg/head/timg.gif", 1, "/wechat","女","喜欢你就像喜欢晴天里晒过的被子一样 好温暖呀","江苏,南京"));

        users.add(new User("zg", "zg", "123456", "周润发","z", "/file/user/zg/head/dfd.gif", 1, "/wechat","男","只有自己的影子，才最忠誠，永遠不會遺棄自己","江苏,苏州"));
        users.add(new User("qg", "qg", "123456", "钱工","q", "/file/user/qg/head/baiqian.jpg", 2, "/warehousing","女","梦里能到达的地方，脚步也能到达。","江苏,苏州"));
        users.add(new User("sg", "sg", "123456", "孙工","s", "/file/common/header01.png", 1, "/wechat","女","等到清酒都喝醉，喉咙灼成灰，眼泪咸成水","江苏,南京"));
       // users.add(new User("zhoug", "zhougong", "123456", "周工", "z","/file/common/timg.gif", 1, "/wechat","男","你来我在甜蜜中等你，你不来我在自由中等你！","江苏,苏州"));
        users.add(new User("hg", "hg", "123456", "好工", "h","/file/common/322000042c908e25faf8.gif", 1, "/wechat","男","人生要干一场有惊喜的事，结一群有情有义的人，活出自己的绝版人生。","江苏,南京"));
        users.add(new User("xg", "xg", "123456", "习工", "x","/file/common/322000042cd203fdfd04.gif", 1, "/wechat","女","不乱于心，不困于情，不畏将来，不念过往。如此，安好！","江苏,苏州"));
        users.add(new User("zgg", "zgg", "123456", "诸葛工","z", "/file/common/322500042813e85030d6.gif", 1, "/wechat","男","记住能记住的，忘记该忘记的；改变能改变的，接受不能改变的","江苏,南京"));
        users.add(new User("oyg", "oyg", "123456", "欧阳","o", "/file/common/timg (2).gif", 1, "/wechat","男","记住能记住的，忘记该忘记的；改变能改变的，接受不能改变的","江苏,南京"));
        users.add(new User("hfg", "hfg", "123456", "皇甫","h", "/file/common/timg (4).gif", 1, "/wechat","男","记住能记住的，忘记该忘记的；改变能改变的，接受不能改变的","江苏,南京"));

    }




    @ResponseBody
    @RequestMapping( "/login" )
    public VenusResponse login(String username, String password) {
        VenusResponse response;
        if (Strings.isEmpty(username)) {
            return new VenusResponse(1000, "用户名不能为空!", null);
        } else if (Strings.isEmpty(password)) {
            return new VenusResponse(1000, "密码不能为空!", null);
        }
        User findUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                findUser = user;
                break;
            }
        }
        if (findUser == null) {
            return new VenusResponse(1000, "用户名不存在!", null);
        }
        if (!findUser.getPassword().equals(password)) {
            return new VenusResponse(1000, "密码错误!", null);
        }

        UsernamePasswordToken tokens = new UsernamePasswordToken(username, password);
        SecurityUtils.getSubject().login(tokens);
        ServletUtils.setSessionAttribute(ConstantUser.login_user, findUser.getUserId());
        return new VenusResponse(200, "登录成功!", findUser);

    }

    /**
     * 用户登出
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping( "/logout" )
    public VenusResponse logout(String userId) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new VenusResponse(200, "登出成功!", null);
    }

    /**
     * 判断是否登录
     * @return
     */
    @ResponseBody
    @RequestMapping( "/isLogin" )
    public String isLogin(){
        Object userId = ServletUtils.getSessionAttribute(ConstantUser.login_user);
        if(null==userId){
            return "false";
        }else{
            return "true";
        }
    }

    @ResponseBody
    @RequestMapping( "/userInfo" )
    public VenusResponse userInfo(String userId) {
        String owner = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        User user = UserUtils.getUserByUserId(userId);
        User other = (User)user.clone();
        String userRemark = UserUtils.getUserRemark(owner, userId);
        other.setRemark(userRemark);
        return new VenusResponse(VenusResponseHttpCode.OK, other);
    }




    /*@ResponseBody
    @RequestMapping( "/firends" )
    public VenusResponse firends(String username) {

        String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
        List<User> userList = new ArrayList<User>();
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                continue;
            }
            userList.add(user);
        }


        return new VenusResponse(VenusResponseHttpCode.OK, userList);
    }*/


}
