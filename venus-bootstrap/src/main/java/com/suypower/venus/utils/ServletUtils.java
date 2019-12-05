package com.suypower.venus.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServletUtils {

    public static ServletRequestAttributes getRequestAttributes() {

        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest() {
        return getRequestAttributes().getRequest();
    }

    /**
     * 往 session 里面存入值
     * @param var1
     * @param var2
     */
    public static void setSessionAttribute(String var1, Object var2){
        getSession().setAttribute(var1,var2);
    }

    /**
     * 从session取值
     * @param var1
     * @return
     */
    public static Object getSessionAttribute(String var1){
        return getSession().getAttribute(var1);
    }

    /**
     * 获取 HttpSession
     * @return
     */
    public static HttpSession getSession(){
        return getRequest().getSession();
    }

}
