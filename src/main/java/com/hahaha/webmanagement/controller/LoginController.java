package com.hahaha.webmanagement.controller;

import com.hahaha.webmanagement.pojo.Emp;
import com.hahaha.webmanagement.pojo.Result;
import com.hahaha.webmanagement.service.EmpService;
import com.hahaha.webmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录{}",emp);
        Emp emp1 = empService.login(emp);
        if (emp1 != null){
            Map<String,Object> cliams = new HashMap<>();
            cliams.put("id",emp.getId());
            cliams.put("name",emp.getName());
            cliams.put("username",emp.getUsername());
            String token = JwtUtils.generateJwt(cliams);
            return Result.success(token);
        }
        return Result.error("用户名或密码错误");


    }
}
