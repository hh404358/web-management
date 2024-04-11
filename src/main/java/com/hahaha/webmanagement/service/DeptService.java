package com.hahaha.webmanagement.service;


import com.hahaha.webmanagement.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 根据id查询
     * @param id
     * @return
     */

    Dept queryById(Integer id);

    void update(Dept dept);
}
