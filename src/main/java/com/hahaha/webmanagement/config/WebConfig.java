package com.hahaha.webmanagement.config;


import com.hahaha.webmanagement.intercepter.LoginCheckIntercepter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckIntercepter loginCheckIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("开始添加拦截器");
        registry.addInterceptor(loginCheckIntercepter).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
