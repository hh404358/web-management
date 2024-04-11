package com.hahaha.webmanagement.mapper;

import com.hahaha.webmanagement.pojo.Dept;
import com.hahaha.webmanagement.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into webmanagement.dept_log(create_time,description)" +
            "        values (#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
