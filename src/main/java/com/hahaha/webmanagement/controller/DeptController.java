package com.hahaha.webmanagement.controller;


import com.hahaha.webmanagement.pojo.Dept;
import com.hahaha.webmanagement.pojo.Result;
import com.hahaha.webmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;

    /**
     * 查询部门数据
     * @return
     */
    //@RequestMapping(value = "/depts",method = RequestMethod.GET) //指定请求方式为GET
    @GetMapping
    public Result list(){
        log.info("开始查询全部部门...");
        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }


    /**
     * 删除部门
     * @return
     */
   @DeleteMapping("/{id}")
   public Result delete(@PathVariable Integer id){
       log.info("开始根据id:{}删除部门",id);
       deptService.delete(id);
       return Result.success();
   }


    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门: {}" , dept);
        //调用service新增部门
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id){
        log.info("根据id:{}查询",id);
        Dept dept = deptService.queryById(id);
        return Result.success();
    }




    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("更新部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }
}
