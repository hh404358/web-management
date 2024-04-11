package com.hahaha.webmanagement.service;


import com.hahaha.webmanagement.pojo.Emp;
import com.hahaha.webmanagement.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    //PageBean page(Integer page, Integer pageSize);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void update(Emp e);

    Emp login(Emp emp);
}
