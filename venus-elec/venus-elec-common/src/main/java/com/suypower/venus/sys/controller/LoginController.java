package com.suypower.venus.sys.controller;


import com.suypower.venus.elec.common.utils.*;
import com.suypower.venus.sys.common.UserConstant;
import com.suypower.venus.sys.common.exception.CaptchaErrorException;
import com.suypower.venus.sys.common.exception.LoginErrorException;
import com.suypower.venus.sys.common.shiro.ShiroRealm;
import com.suypower.venus.sys.entity.Accesses;
import com.suypower.venus.sys.entity.Menu;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IMenuListService;
import com.suypower.venus.sys.impl.IUserService;
import com.suypower.venus.sys.utils.CaptchaUtil;
import com.suypower.venus.sys.utils.RSAUtils;
import com.suypower.venus.platform.web.controller.BaseController;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private ShiroRealm userRealm;
    @Autowired
    private IUserService userService;
    @Autowired
    private IMenuListService menuListService;
    @Value( "${shiro.login.lockCount}" )
    private int lockCount;
    @Value( "${shiro.login.captchaCount}" )
    private int captchaCount;
    @Value( "${shiro.login.lockTime}" )
    private int lockTime;

    @RequestMapping( value = ("/aaa") )
    @ResponseBody
    public VenusResponse noPasswordLogin(String type, String ua, String code,
                                         String token, String ut) {
        return null;
    }

    /**
     * 获取验证码
     *
     * @return
     */
    @RequestMapping( "/plat/secure/code" )
    @ResponseBody
    public VenusResponse code(HttpServletRequest request) {
        ByteArrayOutputStream outputStream = null;
        try {

            //获取验证码图片
            CaptchaUtil tool = new CaptchaUtil();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            // 将内存中的图片通过流动形式输出到客户端
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", outputStream);
            Base64.Encoder encoder = Base64.getEncoder();
            String base64Img = new String(encoder.encode(outputStream.toByteArray()));
            base64Img = "data:image/jpg;base64," + base64Img;
            //存入Shiro的session
            HttpSession session = request.getSession();
            session.setAttribute(UserConstant.KEY_CAPTCHA, code.toString());
            Map<String, String> reslut = new HashMap<>();

            String username = (String)ServletUtils.getSessionAttribute("LoginUser");
            User user = userService.findByUserName(username);
            boolean reset = false;
            if(null!=user && !"2".equals(user.getUserStatus())){
                LocalDateTime errorTime = user.getLoginErrorTime();
                if (null != errorTime) {
                    LocalDateTime now = LocalDateTime.now();
                    Duration between = Duration.between(errorTime, now);
                    long minutes = between.toMillis();
                    if (minutes > (Types.Long(lockTime)) * 1000) {
                        reset = true;
                    }
                    int errorCount = user.getLoginErrorCount();
                    if(errorCount<captchaCount){
                        reset = true;
                    }

                }
            }else{
                reset = true;
            }
            Object sessionAttribute = ServletUtils.getSessionAttribute(UserConstant.RSA_PRIVATE_KEY);
            String publicKey = "";
            if(null==sessionAttribute){
                //RSA加密公钥
                Map<String, String> keyMap = new HashMap<>();
                keyMap = RSAUtils.createRSAKeys();
                //公钥
                 publicKey = keyMap.get(RSAUtils.PUBLIC_KEY_NAME);
                //私钥
                String privateKey = keyMap.get(RSAUtils.PRIVATE_KEY_NAME);
                ServletUtils.setSessionAttribute(UserConstant.RSA_PRIVATE_KEY,privateKey);
                ServletUtils.setSessionAttribute(UserConstant.RSA_PUBLIC_KEY,publicKey);
            }else{
                publicKey =(String) ServletUtils.getSessionAttribute(UserConstant.RSA_PUBLIC_KEY);
            }

            if(reset){
                reslut.put("code", "!" + code.toString());
                reslut.put("src", null);
                reslut.put("utSrc", publicKey);
            }else{
                reslut.put("code", null);
                reslut.put("src", base64Img);
                reslut.put("utSrc", publicKey);
            }


            return new VenusResponse(VenusResponseHttpCode.OK, reslut);
        } catch (Exception e) {
            return new VenusResponse(VenusResponseHttpCode.BadRequest, "获取图片失败");
        } finally {
            String attribute = (String) SecurityUtils.getSubject().getSession().getAttribute(UserConstant.KEY_CAPTCHA);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + attribute);
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }

    }

    /**
     * 用户登录
     *
     * @param type   | 必填参数 | 登录类型(1=账户密码,2=登录秘钥)
     * @param ua     | 必填参数 | 登录用户(loginType=1必填)(用户+密码)用户加密因子混淆后的值
     * @param code   | 可选参数 | 目前验证码(验证码暂时机制,默认2次 不需要验证密码，当错误时需要验证码)如果不用输入,后台回直接返回验证的
     * @param token| 可选参数(loginType=2必填) | 登录密钥用于记住密码登录
     * @param ut|    可选参数 | 登录用户(loginType=1必填) 加密因子,用户前端混淆加密密码的
     * @return
     */
    @RequestMapping( value = ("/plat/sys/user/login") )
    @ResponseBody
    public VenusResponse login(String type, String ua, String code, String token,
                               String ut, HttpServletRequest request) {

        String ipAddr = CommonUtils.getIpAddr(request);
        HttpSession session = request.getSession();
        String keyCaptcha = (String) session.getAttribute(UserConstant.KEY_CAPTCHA);


        User user = null;
        String username = "";
        String passWork = "";
        try {
            Assert.isEmpty(type, "登陆方式不能为空");

            if ("1".equals(type)) {
                Assert.isEmpty(ua, "用户名密码不能为空!");
                String rsa_private_key = (String)ServletUtils.getSessionAttribute(UserConstant.RSA_PRIVATE_KEY);
               Assert.isEmpty(rsa_private_key,"获取公钥失败，请先加密");
                ua = RSAUtils.decodeByPrivateKey(ua,rsa_private_key);

                Assert.isTrue(ua.indexOf("_") < 0, "用户名密码拼接格式错误");
                username = ua.substring(0, ua.indexOf("_"));
                passWork = ua.substring(ua.indexOf("_") + 1);
                session.setAttribute(UserConstant.USER_CAPTCHA, code);

                UsernamePasswordToken tokens = new UsernamePasswordToken(username, passWork);
                SecurityUtils.getSubject().login(tokens);
                user = (User) SecurityUtils.getSubject().getPrincipal();
                String userToken = username + "_" + LocalDateTime.now().format(Times.blankDateTimeFormatter);
                user.setToken(userToken);
                user.setLoginTime(LocalDateTime.now());
                user.setExpire(LocalDateTime.now().plusMonths(1));
                user.setMenus(menuListService.findMenuList());
                ServletUtils.setSessionAttribute(username, user.getToken());
            } else if ("2".equals(type)) {
                Assert.isEmpty(token, "token不存在，请登录!");
                username = StringUtils.parseArray(token, "_")[0];
                user = userService.findByUserName(username);
                passWork = user.getUserPassword();
                String sessionToken = (String) ServletUtils.getSessionAttribute(username);
                Assert.isFalse(token.equals(sessionToken), "该token已过期，请重新登陆");

                UsernamePasswordToken tokens = new UsernamePasswordToken(username, passWork);
                SecurityUtils.getSubject().login(tokens);
                user = (User) SecurityUtils.getSubject().getPrincipal();
                user.setToken(token);
                user.setLoginTime(LocalDateTime.now());
                user.setExpire(LocalDateTime.now().plusMonths(1));
                user.setMenus(menuListService.findMenuList());
            } else {
                Assert.isTrue(true, "登陆方式错误");
            }


        } catch (UnknownAccountException e) {
            return new VenusResponse(VenusResponseHttpCode.AccountPasswordError, e.getMessage()); //用户名不存在
        } catch (LockedAccountException e) {
            return new VenusResponse(VenusResponseHttpCode.AccountLock, e.getMessage()); // 账号锁定
        } catch (CaptchaErrorException e) {
            return new VenusResponse(VenusResponseHttpCode.CoodError, e.getMessage()); //验证码错误
        } catch (LoginErrorException e) {
            return new VenusResponse(VenusResponseHttpCode.AccountPasswordError, e.getMessage()); //密码错误

        }finally {
            ServletUtils.setSessionAttribute("LoginUser", username);
        }


        return new VenusResponse(VenusResponseHttpCode.OK, user);

    }


    @RequestMapping( value = ("/plat/sys/user/complexInfo") )
    @ResponseBody
    public VenusResponse complexInfo(String token) {

       Assert.TokenIsEmpty(token,"token不存在，请登录");
        
        String username = StringUtils.parseArray(token, "_")[0];

        String sessionToken = (String) ServletUtils.getSessionAttribute(username);
        Assert.isFalse(token.equals(sessionToken), "该token已过期，请重新登陆");
        
        User user = userService.findByUserName(username);

        //添加accesses
        List<Accesses> accessesList = new ArrayList<>();
        if (username.equals("admin")) {
            user.setToken(token);
            accessesList.add(new Accesses("plat_user_add", "添加用户", "1", "该功能只能在12:00-14:00之间使用"));
            accessesList.add(new Accesses("plat_menu_add", "添加菜单", "2", "该功能只能在12:00-14:00之间使用"));
        } else if (username.equals("test")) {
            user.setToken(token);
            accessesList.add(new Accesses("plat_menu_add", "添加菜单", "2", "该功能只能在12:00-14:00之间使用"));
        }
        user.setAccesses(accessesList);

        user.setMenus(menuListService.findMenuList());

        return new VenusResponse(VenusResponseHttpCode.OK, user);


    }


    /**
     * 用户登出
     *
     * @param token
     * @return
     */
    @RequestMapping( value = ("/plat/sys/user/logout") )
    @ResponseBody
    public VenusResponse logout(String token) {
       Assert.TokenIsEmpty(token,"token不存在，请登录");
        String username = StringUtils.parseArray(token, "_")[0];
        String sessionToken = (String) ServletUtils.getSessionAttribute(username);
        Assert.isFalse(token.equals(sessionToken), "该token已过期，请重新登陆");
        User user = userService.findByUserName(username);

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new VenusResponse(VenusResponseHttpCode.OK, user);
    }

    /**
     * 获取用户菜单
     *
     * @return
     */
    @RequestMapping( value = ("/plat/sys/menu/list") )
    @ResponseBody
    public VenusResponse menuList() {
        List<Menu> menuList = menuListService.findMenuList();
        return new VenusResponse(VenusResponseHttpCode.OK, menuList);
    }


    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @RequestMapping( value = ("/plat/sys/user/info") )
    @ResponseBody
    public VenusResponse userInfo(String token) {
       Assert.TokenIsEmpty(token,"token不存在，请登录");

        String username = StringUtils.parseArray(token, "_")[0];

        String sessionToken = (String) ServletUtils.getSessionAttribute(username);
        Assert.isFalse(token.equals(sessionToken), "该token已过期，请重新登陆");
        User user = userService.findByUserName(username);
        return new VenusResponse(VenusResponseHttpCode.OK, user);
    }

}
