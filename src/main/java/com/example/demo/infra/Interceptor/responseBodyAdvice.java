package com.example.demo.infra.Interceptor;

import com.example.demo.DTO.testDTO;
import com.example.demo.infra.untils.ThreadLocalUntils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@ControllerAdvice
public class responseBodyAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        //获取返回类型
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        testDTO testDTO = ThreadLocalUntils.getThreadLocal().get();
        System.out.println(testDTO);
        return "world";
    }
}
