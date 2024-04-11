package com.hahaha.webmanagement.service.impl;


import com.hahaha.webmanagement.mapper.DeptMapper;
import com.hahaha.webmanagement.mapper.EmpMapper;
import com.hahaha.webmanagement.pojo.Dept;
import com.hahaha.webmanagement.pojo.DeptLog;
import com.hahaha.webmanagement.service.DeptLogService;
import com.hahaha.webmanagement.service.DeptService;
import com.hahaha.webmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    @Transactional
    public void delete(Integer id) {


        try {
            deptMapper.deleteById(id);
            empMapper.deleteByDeptId(id);
            //int i = 1/0;
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行解散部门的操作");
            deptLogService.insert(deptLog);
        }



    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }
    @Override
    public Dept queryById(Integer id){
        return deptMapper.queryById(id);
    }
    @Override
    public void update(Dept dept){
        deptMapper.update(dept);
    }
}
