package com.easyjava.test.config;

import com.easyjava.test.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        注意这里不能包含application.yaml内的prefix
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")  // 仅拦截登录接口
                .excludePathPatterns("/account/login**","/account/*"); // 排除验证码接口
    }
}
