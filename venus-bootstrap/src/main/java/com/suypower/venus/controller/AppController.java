package com.suypower.venus.controller;

import com.alibaba.fastjson.JSONObject;
import com.suypower.venus.entity.App;
import com.suypower.venus.entity.AppGroup;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/api/app" )
public class AppController {
    public static List<AppGroup> appGroupList = new ArrayList<>();

    static {
        appGroupList.add(new AppGroup("general", "通用", new ArrayList<App>() {{
            this.add(new App("notice", "公告", "red", "notice.png", 1));
            this.add(new App("comInfo", "企业详情", "yellow", "approval.png", 1));
            this.add(new App("comInfo", "审批", "blue", "approval.png", 0));
            this.add(new App("businessOppReport", "商机上报", "green", "approval.png", 0));
        }}));

        appGroupList.add(new AppGroup("task", "任务", new ArrayList<App>() {{
            this.add(new App("notice", "日程", "red", "schedule.png", 1));
            this.add(new App("comInfo", "任务", "green", "task.png", 0));
            this.add(new App("comInfo", "考勤打卡", "yellow", "attendance-card.png", 1));
        }}));

        appGroupList.add(new AppGroup("sales", "销售", new ArrayList<App>() {{
            this.add(new App("notice", "在线下单", "red", "order-online.png", 0));
            this.add(new App("comInfo", "全部订单", "yellow", "schedule.png", 1));
        }}));

        appGroupList.add(new AppGroup("sales", "申请", new ArrayList<App>() {{
            this.add(new App("notice", "出差申请", "red", "evection.png", 1));
            this.add(new App("comInfo", "请假申请", "yellow", "leave.png", 0));
            this.add(new App("comInfo", "报销申请", "blue", "reimbursement.png", 1));
            this.add(new App("comInfo", "工作请示", "green", "work-instructions.png", 1));
        }}));

        appGroupList.add(new AppGroup("sales", "报告", new ArrayList<App>() {{
            this.add(new App("notice", "库存上报", "red", "inventory-report.png", 1));
            this.add(new App("comInfo", "日报", "green", "daily.png", 1));
            this.add(new App("comInfo", "周报", "yellow", "weekly.png", 0));
            this.add(new App("comInfo", "月报", "blue", "monthly-report.png", 1));
        }}));





    }

    @ResponseBody
    @RequestMapping( "/appList" )
    public VenusResponse appList() {
        JSONObject result = new JSONObject();
        result.put("total", totalNum());
        result.put("groups",appGroupList);

        return new VenusResponse(VenusResponseHttpCode.OK, result);
    }

    public static  int  totalNum() {
        int totalNum = 0;
        for(AppGroup group:appGroupList){
            List<App> apps = group.getApps();
            if(null!=apps&&apps.size()>0){
                for(App app:apps){
                    int unread = app.getUnread();
                    totalNum+=unread;
                }
            }
        }
        return totalNum;
    }

    @ResponseBody
    @RequestMapping( "/addReadNum" )
    public VenusResponse addReadNum(String appId, int num) {
        VenusResponse x = getVenusResponse(appId, num);
        if (x != null) return x;

        addOrSubNum(appId, num, add);

        return new VenusResponse(VenusResponseHttpCode.OK, "添加成功");
    }


    @ResponseBody
    @RequestMapping( "/subReadNum" )
    public VenusResponse subReadNum(String appId, int num) {
        VenusResponse x = getVenusResponse(appId, num);
        if (x != null) return x;

        addOrSubNum(appId, num, sub);

        return new VenusResponse(VenusResponseHttpCode.OK, "减少成功");
    }

    static final String add = "1";
    static final String sub = "0";

    /**
     * @param appId
     * @param num
     * @param type  1:加  0：减
     */
    public static void addOrSubNum(String appId, int num, String type) {
        if (StringUtils.isEmpty(type)) {
            throw new RuntimeException("addOrSubNum方法:type参数类型不正确,type不许为1或者2");
        }
        List<AppGroup> appGroupList = AppController.appGroupList;
        for (AppGroup group : appGroupList) {
            List<App> apps = group.getApps();
            if (null != apps && apps.size() > 0) {
                for (App app : apps) {
                    if (app.getAppId().equals(appId)) {
                        int unread = app.getUnread();
                        //判断加减
                        if (type.equals(add)) {
                            app.setUnread(unread + num);
                        } else if (type.equals(sub)) {
                            int finNum = unread - num;
                            if (finNum < 1) {
                                app.setUnread(0);
                            } else {
                                app.setUnread(finNum);
                            }
                        }
                        break;

                    }
                }
            }
        }
    }

    private VenusResponse getVenusResponse(String appId, int num) {
        if (Strings.isEmpty(appId)) {
            return new VenusResponse(1000, "appId不能为空!", null);
        } else if (num < 1) {
            return new VenusResponse(1000, "num必须大于0的整数", null);
        }
        return null;
    }

}
