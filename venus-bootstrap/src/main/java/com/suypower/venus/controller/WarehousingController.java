package com.suypower.venus.controller;

import com.suypower.venus.entity.OperationLog;
import com.suypower.venus.entity.OperationLogManger;
import com.suypower.venus.entity.Warehousing;
import com.suypower.venus.platform.web.response.VenusResponse;
import com.suypower.venus.utils.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping( "/api/warehousing" )
public class WarehousingController {
    public static OperationLogManger opm = new OperationLogManger();

    public static List<Warehousing> warehousings = new ArrayList<Warehousing>();

    public static List<String> examineList = new ArrayList<>();

    static {
//        UUID.randomUUID().toString().replace("-","")
        warehousings.add(new Warehousing("1","1号库区", "1号库位", "工业盐", "200kg", "通过"));
        warehousings.add(new Warehousing("2","3号库区", "2号库位", "泡菜盐", "160kg", "审核"));

        examineList.add("通过");
        examineList.add("审核");
        examineList.add("不通过");

        opm.addInitOperationLog("1", "提交");
        opm.addInitOperationLog("1", "审核中");
        opm.addInitOperationLog("1", "通过");
        opm.addInitOperationLog("2", "提交");
        opm.addInitOperationLog("2", "审核中");
    }


    /**
     * @param area  库区 可选
     * @param location 库位 可选
     * @param status 状态 可选 （例如:   "通过,审核"   或者   "审核"）
     * @return
     */
    @ResponseBody
    @RequestMapping( "/list" )
    public VenusResponse list(String area, String location, String status) {

        List<Warehousing> source = warehousings;
        List<Warehousing> target = new ArrayList<>();

        if(StringUtils.isEmpty(area)){
            target = source;
        }else{
            for (Warehousing warehousing : source) {
                String area1 = warehousing.getArea();
                if(area1.equals(area)){
                    target.add(warehousing);
                }
            }
        }
        source = target;
        target = new ArrayList<>();

        if(StringUtils.isEmpty(location)){
            target = source;
        }else{
            for (Warehousing warehousing : source) {
                String location1 = warehousing.getLocation();
                if(location.equals(location1)){
                    target.add(warehousing);
                }
            }
        }
        source = target;
        target= new ArrayList<>();

        if(StringUtils.isEmpty(status)){
            target = source;
        }else{
            String[] statuses = status.split(",");

            for (Warehousing warehousing : source) {
                String status1 = warehousing.getStatus();
                for(String inStatus:statuses){
                    if(inStatus.equals(status1)){
                        target.add(warehousing);
                    }
                }

            }
        }

       /* for (Warehousing warehousing : source) {
            if (StringUtils.isEmpty(location) ) {
                continue;
            }else {
                if(StringUtils.isEmpty(location)){
                    continue;
                }else{
                    if(StringUtils.isEmpty(location)){
                        continue;
                    }else{
                        target.add(warehousing) ;
                    }
                }
            }

        }*/

        return new VenusResponse(200, "成功!", target);
    }

    @ResponseBody
    @RequestMapping( "/examineList" )
    public VenusResponse examine(String id, String status) {
        if (Strings.isEmpty(id)) {
            return new VenusResponse(1000, "id不能为空!", null);
        } else if (Strings.isEmpty(status)) {
            return new VenusResponse(1000, "审核状态不能为空", null);
        }
        if (!examineList.contains(status)) {
            return new VenusResponse(1000, "审核状态不规范", null);
        }
        for (Warehousing warehousing : warehousings) {
            String id1 = warehousing.getId();
            if (id.equals(id1)) {
                warehousing.setStatus(status);
            }
        }
        opm.addOperationLog(id, status);
        return new VenusResponse(200, "审核成功", null);
    }

    @ResponseBody
    @RequestMapping( "/add" )
    public VenusResponse add(String area, String location, String product, String output) {
        VenusResponse response;
        if (Strings.isEmpty(area)) {
            return new VenusResponse(1000, "库区不能为空!", null);
        } else if (Strings.isEmpty(location)) {
            return new VenusResponse(1000, "库位不能为空!", null);
        } else if (Strings.isEmpty(product)) {
            return new VenusResponse(1000, "产品不能为空!", null);
        } else if (Strings.isEmpty(output)) {
            return new VenusResponse(1000, "产量不能为空!", null);
        }
        String id = UUID.randomUUID().toString().replace("-", "");
        Warehousing warehousing = new Warehousing(id,area, location, product, output, "审核");
        warehousings.add(0, warehousing);
//        User findUser = null;
//        for(User user : users){
//            if(user.getUsername().equals(username)){
//                findUser = user;
//                break;
//            }
//        }
//        if(findUser==null){
//            return new VenusResponse(1000,"用户名不存在!",null);
//        }
//        if(!findUser.getPassword().equals(password)){
//            return new VenusResponse(1000,"密码错误!",null);
//        }
        opm.addOperationLog(warehousing.getId(), "提交");
        opm.addOperationLog(warehousing.getId(), "审核中");
        return new VenusResponse(200, "提交产量成功!", warehousing);

    }

    @ResponseBody
    @RequestMapping( "/detail" )
    public VenusResponse list(String id) {
        Warehousing warehousing = Warehousing.getWarehousing(id);
        if(null!=warehousing){
            List<OperationLog> operationLogs = opm.findOperationLogs(id);
            warehousing.setLogs(operationLogs);
        }

        return new VenusResponse(200, "详情查找成功", warehousing);
    }
}
