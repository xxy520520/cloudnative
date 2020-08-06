package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Edwin Xu on 7/31/2020 11:44 AM
 */

@Component
public class AccessLimtInterceptor implements HandlerInterceptor {
    private int count=0;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            int maxCount = accessLimit.maxCount();
            if (count<maxCount){
                count++;
                System.out.println("count++ : "+count);
                return true;
            }else{
                System.out.println("429:Too many requests");
                response.setStatus(429); //429:Too many requests
                return false;
            }
        }
        return true;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        count--;
        System.out.println("count-- : "+count);
    }
}