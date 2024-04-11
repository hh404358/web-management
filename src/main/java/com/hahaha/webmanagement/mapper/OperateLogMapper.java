package com.hahaha.webmanagement.mapper;

import com.hahaha.webmanagement.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    @Insert("insert into webmanagement.operate_log(id, operate_user, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "VALUES(#{id},#{operateUser},#{operateTime},#{className},#{methodName},#{methodParams},#{returnValue},#{costTime}) ")
    public void insert(OperateLog operateLog) ;

}
