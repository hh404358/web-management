package com.hahaha.webmanagement.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hahaha.webmanagement.anno.MyLog;
import com.hahaha.webmanagement.mapper.EmpMapper;
import com.hahaha.webmanagement.pojo.Emp;
import com.hahaha.webmanagement.pojo.PageBean;
import com.hahaha.webmanagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
  //  @Override
//    public PageBean page(Integer page, Integer pageSize){
//        Long count = empMapper.count();
//        Integer start = (page - 1)*pageSize;
//        List<Emp> empList = empMapper.page(start,pageSize);
//        return new PageBean(count,empList);
//    }

    /*@Override
    public PageBean page(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long count = empMapper.count();

        //2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }*/


    @Override
    @MyLog
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p =(Page<Emp>)empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    @MyLog
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    @MyLog
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    @MyLog
    public void update(Emp e) {
        empMapper.update(e);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }
}
