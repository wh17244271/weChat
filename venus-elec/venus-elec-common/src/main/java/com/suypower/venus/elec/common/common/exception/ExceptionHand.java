package com.suypower.venus.elec.common.common.exception;

import com.suypower.venus.sys.common.exception.CaptchaErrorException;
import com.suypower.venus.sys.common.exception.LoginErrorException;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理类，用来处理request请求，响应时异常处理，用于Controller层
 */
@ControllerAdvice
public class ExceptionHand {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 返回对象 VenusResponse提示异常
     * @param e
     * @return
     */
    @ExceptionHandler({VenusResponseException.class})
    @ResponseBody
    public VenusResponse exception(VenusResponseException e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.InternalServerError, e.getMessage());

    }
    /**
     * 权限异常
     * @param e
     * @return
     */
    @ExceptionHandler({PermissionException.class})
    @ResponseBody
    public VenusResponse  exception(PermissionException e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.NoPermission, e.getMessage());

    }

    /**
     * 集合shiro自定义的登陆异常
     * @param e
     * @return
     */
    @ExceptionHandler({LoginErrorException.class})
    @ResponseBody
    public VenusResponse  exception(LoginErrorException e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.InternalServerError, e.getMessage());

    }

    /**
     * 集合shiro自定义的验证码错误异常
     * @param e
     * @return
     */
    @ExceptionHandler({CaptchaErrorException.class})
    @ResponseBody
    public VenusResponse  exception(CaptchaErrorException e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.InternalServerError, e.getMessage());

    }



    /**
     * 捕捉运行时异常
     * @param e
     * @return
     */
    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public VenusResponse exception(RuntimeException e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.BadRequest, "运行出错，请联系系统管理员");

    }

    /**
     * 捕捉最终异常
     * @param e
     * @return
     */
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public VenusResponse exception(Exception e) {
        e.printStackTrace();
        logger.error(">>>>>>>>>>>>>>>>>错误信息:{}", e.getMessage());
        return new VenusResponse(VenusResponseHttpCode.BadRequest, "系统出错，请联系系统管理员");

    }
 


}
