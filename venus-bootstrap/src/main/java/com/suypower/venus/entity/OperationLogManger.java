package com.suypower.venus.entity;

import com.suypower.venus.common.ConstantUser;
import com.suypower.venus.utils.ServletUtils;
import com.suypower.venus.utils.UserUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OperationLogManger {
    private  List<OperationLog> operationLogs = new ArrayList<>();

    public OperationLogManger() {
        operationLogs = new ArrayList<>();
    }

    /**
     * 添加记录
     * @param id
     * @param process
     */
    public void addOperationLog(String id,String process){
        OperationLog operationLog = new OperationLog(id,process);
        operationLogs.add(operationLog);
    }

    public void addInitOperationLog(String id,String process){
        OperationLog operationLog = new OperationLog();
        operationLog.setId(id);
        operationLog.setDisc(process);
        operationLog.setUserId("lg");
        operationLog.setUserName(UserUtils.getUserNicename("lg"));
        operationLog.setTime(LocalDateTime.now());
        operationLogs.add(operationLog);
    }


    /**
     * 通过id查找操作日志列表
     * @param id
     * @return
     */
    public List<OperationLog>  findOperationLogs(String id){
        List<OperationLog> find = new ArrayList<>();
        for(OperationLog log:operationLogs){
            String id1 = log.getId();
            String userId = (String) ServletUtils.getSessionAttribute(ConstantUser.login_user);
            String userId1 = log.getUserId();
            if(id1.equals(id) /*&& userId1.equals(userId)*/){
                find.add(log) ;
            }
        }
       return find;
    }


    public OperationLogManger(List<OperationLog> operationLogs) {
        this.operationLogs = operationLogs;
    }

    public List<OperationLog> getOperationLogs() {
        return operationLogs;
    }

    public void setOperationLogs(List<OperationLog> operationLogs) {
        this.operationLogs = operationLogs;
    }
}
