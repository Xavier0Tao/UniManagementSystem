package org.uni.Interceptors;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(20)//20-40
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("...interceptor pre 开始....");

        Object role =  request.getSession().getAttribute("ROLE");
        if (role != null) {
            return true;
        }

        System.out.println("没有放行....");
        return false;
    }

}
