package com.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("user");
        Object admin = httpSession.getAttribute("user");
        if (user!=null){
            return true;
        }else {
            response.sendRedirect("/SpringByAnnotation/user/login");
        }
        return false;
    }
}
