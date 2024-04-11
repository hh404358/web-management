package com.hahaha.webmanagement.service.impl;

import com.hahaha.webmanagement.mapper.DeptLogMapper;
import com.hahaha.webmanagement.pojo.DeptLog;
import com.hahaha.webmanagement.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insert(DeptLog deptLog){
        deptLogMapper.insert(deptLog);
    }
}
