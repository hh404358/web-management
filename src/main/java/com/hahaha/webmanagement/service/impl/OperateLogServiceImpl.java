package com.hahaha.webmanagement.service.impl;


import com.hahaha.webmanagement.mapper.OperateLogMapper;
import com.hahaha.webmanagement.pojo.OperateLog;
import com.hahaha.webmanagement.service.OpearteLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperateLogServiceImpl implements OpearteLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public void insert(OperateLog operateLog) {
        operateLogMapper.insert(operateLog);
    }
}
