package com.hahaha.webmanagement.aop;

import com.alibaba.fastjson.JSONObject;
import com.hahaha.webmanagement.pojo.OperateLog;
import com.hahaha.webmanagement.service.OpearteLogService;
import com.hahaha.webmanagement.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Slf4j
@Aspect
public class LogAspect {
    @Pointcut("@annotation(com.hahaha.webmanagement.anno.MyLog)")
    private void pt(){}
    @Autowired
    private OpearteLogService opearteLogService;
    @Autowired
    private HttpServletRequest request;

    @Around("pt()")
    public Object recordLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer)claims.get("id");
        LocalDateTime now = LocalDateTime.now();
        String className = proceedingJoinPoint.getClass().getName();
        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Long start = System.currentTimeMillis();

        Object object = proceedingJoinPoint.proceed();
        String returnValue = JSONObject.toJSONString(object);

        Long end = System.currentTimeMillis();
        Long costTime = end - start;
        log.info(proceedingJoinPoint.getSignature()+"执行耗时：{}ms",end-start);

        OperateLog operateLog = new OperateLog(null,operateUser,now,className,method,args,returnValue,costTime);
        opearteLogService.insert(operateLog);
        return object;


    }


}
