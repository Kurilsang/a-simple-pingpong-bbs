package com.easyjava.test.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.easyjava.test.component.RedisComponent;
import com.easyjava.test.controller.ABaseController;
import com.easyjava.test.entity.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class LoginCheckInterceptor extends ABaseController implements HandlerInterceptor  {
    private final RedisComponent redisComponent;

    public LoginCheckInterceptor(RedisComponent redisComponent) {
        this.redisComponent = redisComponent;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
//            return true;
//        }
//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
//        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 拦截器中需添加 概率会触发预检，导致跨域问题，，，
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true; // 直接放行
        }
          String token = request.getHeader("token");

        System.out.println("标记4"+token);
          if(null==token)
          {
              String notLogin = JSONObject.toJSONString(getSuccessResponseVO("未登录"));
                response.getWriter().write("notLogin");
              System.out.println("标记3"+notLogin);
                return false;
          }
        System.out.println("标记4"+token);
          if(null==redisComponent.getTokenInfo(token))
          {
              ResponseVO error = getSuccessResponseVO("未登录");
            String notLogin = JSONObject.toJSONString(error);
              System.out.println("标记3"+notLogin);
            response.getWriter().write("notLogin");
              return false;
          }
//        String jwt = request.getHeader("token");
//        if(jwt == null || jwt.equals("")) {
//            log.info("无token");
//            String notLogin = JSONObject.toJSONString(Result.error("NOT_LOGIN"));
//            response.getWriter().write(notLogin);
//            return false;
//        }
////      解析失败返回未登录
//        try{
//            JWTUtitls.verifyToken(jwt);
//        }catch (Exception e){
//            log.info("token解析失败");
//            Result error = Result.error("NOT_LOGIN");
//            String notLogin = JSONObject.toJSONString(error);
//            response.getWriter().write(notLogin);
//            return false;
//        }
//        log.info("jwt校验无问题，放行");
        return true;
    }
}
