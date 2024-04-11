package com.hahaha.webmanagement.filter;


import com.alibaba.fastjson.JSONObject;
import com.hahaha.webmanagement.pojo.Result;
import com.hahaha.webmanagement.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")//如果注释掉则不执行过滤器
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取url
        String url = request.getRequestURI();
        log.info("请求url:{}",url);

        //请求为登录请求
        if(url.contains("login")){
            log.info("登录请求，放行");
            filterChain.doFilter(request,response);
            return;
        }

        //获取令牌
        String jwt = request.getHeader("token");

        //令牌不存在返回错误结果
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        //token解析
        try{
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            log.info("令牌解析错误");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        log.info("令牌合法，放行");
        filterChain.doFilter(request,response);

    }
}
