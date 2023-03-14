package com.example.antd.antd_pro.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在请求处理之前进行拦截，判断用户是否已登录
        String token = request.getHeader("Authorization");
        if (token == null) {
            // 如果用户未登录，重定向到登录页面
            response.sendRedirect("/api/user/login");
            return false;
        }
        // 如果用户已登录，放行请求
        return true;
    }
}
