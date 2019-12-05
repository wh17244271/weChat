package com.suypower.venus.controller;

import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.entity.Expression;
import com.suypower.venus.entity.User;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.platform.web.response.VenusResponseHttpCode;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.UserChatRoomManage;
import com.suypower.venus.utils.UserUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping( "/api/set/sys" )
public class SetSysController {
    @Value( "${upload.path}" )
    private String uploadPath;

    public static List<Expression> expressionList = new ArrayList<>();


    @ResponseBody
    @RequestMapping( "/getSysExp" )
    public VenusResponse getSysExp() {

        if (null==expressionList || expressionList.size()<1){
            String url = "/file/expression_sys/";
            expressionList.add(new Expression("1",url+"01.png"));
            expressionList.add(new Expression("1",url+"02.png"));
            expressionList.add(new Expression("1",url+"03.png"));
            expressionList.add(new Expression("1",url+"04.png"));
            expressionList.add(new Expression("1",url+"05.png"));
            expressionList.add(new Expression("1",url+"06.png"));
            expressionList.add(new Expression("1",url+"07.png"));
            expressionList.add(new Expression("1",url+"08.png"));
            expressionList.add(new Expression("1",url+"09.png"));
            expressionList.add(new Expression("1",url+"10.png"));
            expressionList.add(new Expression("1",url+"10.png"));
            expressionList.add(new Expression("1",url+"11.png"));
            expressionList.add(new Expression("1",url+"12.png"));
            expressionList.add(new Expression("1",url+"13.png"));
            expressionList.add(new Expression("1",url+"14.png"));
            expressionList.add(new Expression("1",url+"15.png"));
            expressionList.add(new Expression("1",url+"16.png"));
            expressionList.add(new Expression("1",url+"17.png"));
            expressionList.add(new Expression("1",url+"18.png"));
            expressionList.add(new Expression("1",url+"19.png"));
            expressionList.add(new Expression("1",url+"20.png"));
            expressionList.add(new Expression("1",url+"21.png"));
            expressionList.add(new Expression("1",url+"22.png"));
            expressionList.add(new Expression("1",url+"23.png"));
            expressionList.add(new Expression("1",url+"24.png"));
            expressionList.add(new Expression("1",url+"25.png"));
            expressionList.add(new Expression("1",url+"26.png"));
            expressionList.add(new Expression("1",url+"27.png"));
            expressionList.add(new Expression("1",url+"28.png"));
            expressionList.add(new Expression("1",url+"29.png"));
            expressionList.add(new Expression("1",url+"30.png"));
            expressionList.add(new Expression("1",url+"31.png"));
            expressionList.add(new Expression("1",url+"32.png"));
            expressionList.add(new Expression("1",url+"33.png"));
            expressionList.add(new Expression("1",url+"34.png"));
            expressionList.add(new Expression("1",url+"35.png"));
            expressionList.add(new Expression("1",url+"36.png"));
            expressionList.add(new Expression("1",url+"37.png"));
            expressionList.add(new Expression("1",url+"38.png"));
            expressionList.add(new Expression("1",url+"39.png"));
            expressionList.add(new Expression("1",url+"40.png"));
            expressionList.add(new Expression("1",url+"41.png"));
            expressionList.add(new Expression("1",url+"42.png"));
            expressionList.add(new Expression("1",url+"43.png"));
            expressionList.add(new Expression("1",url+"44.png"));
            expressionList.add(new Expression("1",url+"45.png"));
            expressionList.add(new Expression("1",url+"46.png"));
            expressionList.add(new Expression("1",url+"47.png"));
            expressionList.add(new Expression("1",url+"48.png"));
            expressionList.add(new Expression("1",url+"49.png"));
            expressionList.add(new Expression("1",url+"50.png"));
            expressionList.add(new Expression("1",url+"51.png"));
            expressionList.add(new Expression("1",url+"52.png"));
            expressionList.add(new Expression("1",url+"53.png"));
            expressionList.add(new Expression("1",url+"54.png"));
            expressionList.add(new Expression("1",url+"55.png"));
            expressionList.add(new Expression("1",url+"56.png"));
            expressionList.add(new Expression("1",url+"57.png"));
            expressionList.add(new Expression("1",url+"58.png"));
            expressionList.add(new Expression("1",url+"59.png"));
            expressionList.add(new Expression("1",url+"60.png"));
            expressionList.add(new Expression("1",url+"61.png"));
            expressionList.add(new Expression("1",url+"62.png"));


        }

        return new VenusResponse(VenusResponseHttpCode.OK, expressionList);
    }




}
