package com.example.demo.infra.Interceptor;

import com.alibaba.fastjson.JSON;
import com.example.demo.DTO.testDTO;
import com.example.demo.infra.untils.ThreadLocalUntils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class testIneterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadLocalUntils.getThreadLocaltest().set(new HashMap<Object,Object>());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        testDTO testDTO = ThreadLocalUntils.getThreadLocal().get();
        response.setHeader("test", "成功");
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        testDTO testDTO = ThreadLocalUntils.getThreadLocal().get();
        String name = Thread.currentThread().getName();
        ThreadLocalUntils.getThreadLocal().remove();
        System.out.println("afterCompletion");
    }
}
