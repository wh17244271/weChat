package com.suypower.venus.elec.common.utils;

import com.suypower.venus.elec.common.common.exception.VenusResponseException;
import com.suypower.venus.elec.common.query.DaMpQuery;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class CommonUtils {

    /**
     * 获取当前网络ip
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){

        String ipAddress = request.getHeader("x-forwarded-for");
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress= inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
            if(ipAddress.indexOf(",")>0){
                ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    /**
     * 获取集合中的第一条数据
     * @param ts
     * @param <T>
     * @return
     */
    public static <T>T getFirstList(List<T> ts){
        if(ts==null)return null;
        T t = null;
        if(ts.size()>0){
            t = ts.get(0);
        }
        return t;
    }

    /**
     * 查询日多条数据，判断日期不能为空
     * 为了限制在查询日数据时候传递非 day 和month的时间类型
     * @param daMpQuery
     */
    public static void dayTimeTypeNotApplicable(DaMpQuery daMpQuery ){
        Assert.isTrue(StringUtils.isEmpty(daMpQuery.getDataDates()) && StringUtils.isEmpty(daMpQuery.getDataMonths()),
                "该日期类型不适用，请更换");
//        if(StringUtils.isEmpty(daMpQuery.getDataDates()) && StringUtils.isEmpty(daMpQuery.getDataMonths())){
//            throw new VenusResponseException("该日期类型不适用，请更换");
//        }
    }

    /**
     * 查询月多条数据，判断日期不能为空
     * 为了限制在查询月数据时候传递非 year 和month的时间类型
     * @param daMpQuery
     */
    public static void monthTimeTypeNotApplicable(DaMpQuery daMpQuery ){
//        Assert.isTrue(StringUtils.isEmpty(daMpQuery.getDataYears()) && StringUtils.isEmpty(daMpQuery.getDataMonths())),
//                "该日期类型不适用，请更换");
        if(StringUtils.isEmpty(daMpQuery.getDataYears()) && StringUtils.isEmpty(daMpQuery.getDataMonths())){
            throw new VenusResponseException("该日期类型不适用，请更换");
        }
    }
}
