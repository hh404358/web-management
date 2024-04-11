package com.hahaha.webmanagement.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Slf4j
//@Aspect
public class TimeAspect {
    @Pointcut("@annotation(com.hahaha.webmanagement.anno.MyLog)")
    private void pt(){}
    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object object = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"执行耗时：{}ms",end-start);
        return object;
    }
}
