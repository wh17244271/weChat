package com.suypower.venus.sys.common.shiro;

import com.suypower.venus.elec.common.utils.ServletUtils;
import com.suypower.venus.elec.common.utils.StringUtils;
import com.suypower.venus.sys.common.UserConstant;
import com.suypower.venus.sys.common.exception.CaptchaErrorException;
import com.suypower.venus.sys.common.exception.LoginErrorException;
import com.suypower.venus.sys.entity.User;
import com.suypower.venus.sys.impl.IUserService;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

import static com.suypower.venus.sys.common.UserConstant.KEY_CAPTCHA;
import static com.suypower.venus.sys.common.UserConstant.USER_CAPTCHA;


/**
 * @author: WangSaiChao
 * @date: 2018/5/25
 * @description: 登陆次数限制
 * <p>
 * SimpleCredentialsMatcher 不加密
 * HashedCredentialsMatcher     加密
 */
public class RetryLimitHashedCredentialsMatcher extends SimpleCredentialsMatcher {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private IUserService userService;
    private Cache<String, AtomicInteger> passwordRetryCache;

    @Value( "${shiro.login.lockTime}" )
    private long lockTime;
    @Value( "${shiro.login.lockCount}" )
    private int lockCount;
    @Value( "${shiro.login.captchaCount}" )
    private int captchaCount;


    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    public Cache<String, AtomicInteger> getCache() {
        return passwordRetryCache;
    }


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        //获取用户名
        String username = (String) token.getPrincipal();
        User user = userService.findByUserName(username);
        LocalDateTime now = LocalDateTime.now();
        HttpSession session = ServletUtils.getSession();

        int errorCount = user.getLoginErrorCount();
        String status = user.getUserStatus();
        LocalDateTime errorTime = user.getLoginErrorTime();
        if((errorCount >0 && errorCount<lockCount) ){
            Duration between = Duration.between(errorTime, now);
            long minutes = between.toMillis();
            if (minutes > (lockTime) * 1000) {
                userService.updateUserStatus(UserConstant.status_normal,0,now,username);
                errorTime = now;
                errorCount = 0;
                status=UserConstant.status_normal;
            }
        }
        if(UserConstant.status_lock.equals(status)){
            Duration between = Duration.between(errorTime, now);
            long minutes = between.toMillis();
            userService.updateUserStatus(UserConstant.status_lock,errorCount,errorTime,username);
            throw new LockedAccountException("密码错误次数过多，账号已被锁定，请" + (lockTime - minutes / 1000) + "秒后再试");
        }

        if (errorCount >= captchaCount && errorCount < lockCount) {
            //验证码
            String keyCaptcha = (String) session.getAttribute(KEY_CAPTCHA);
            String userCaptcha = (String) session.getAttribute(USER_CAPTCHA);
            if (StringUtils.isEmpty(userCaptcha) || StringUtils.isEmpty(keyCaptcha) ||
                    !userCaptcha.toLowerCase(Locale.CHINA).equals(keyCaptcha.toLowerCase(Locale.CHINA))) {
                throw new CaptchaErrorException("验证码错误");
            }
        }

        //判断用户账号和密码是否正确
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            session.removeAttribute(KEY_CAPTCHA);
            session.removeAttribute(USER_CAPTCHA);
            userService.updateUserStatus(UserConstant.status_normal,0,now,username);
            return matches;
        }else{
            //记录错误时间 因为从0开始计数，需要+1

            if(errorCount+1 ==lockCount){
                userService.updateUserStatus(UserConstant.status_lock,errorCount,now,username);
                throw new LockedAccountException("账号已锁定");
            }
            errorCount +=1;
            userService.updateUserStatus(UserConstant.status_normal,errorCount,now,username);
            throw new LoginErrorException("用户名或密码不对,剩余" + (lockCount - errorCount) + "次机会");
        }
    }

}
