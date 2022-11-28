package com.example.demo.cotroller;

import com.example.demo.DTO.testDTO;
import com.example.demo.infra.repository.testMapper;
import com.example.demo.infra.untils.ThreadLocalUntils;
import com.example.demo.service.commonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/common")
public class common {
    static final String field="zhangsan";
    @Autowired
    testMapper mapper;
    @Autowired
    commonService service;
    @GetMapping("/hello")
    public ResponseEntity<Map> common() throws Exception {
        //塞一个线程变量
        ThreadLocal<testDTO> threadLocal = ThreadLocalUntils.getThreadLocal();
        testDTO testDTO = new testDTO();
        testDTO.setName(field);
        threadLocal.set(testDTO);
        Thread.currentThread().getName();
        Map threadLocalMap = ThreadLocalUntils.getThreadLocalMap();
        threadLocalMap.put("name","小张");
        service.common();
        Map test = mapper.test();
        threadLocalMap.putAll(test);
        return ResponseEntity.ok(threadLocalMap);
    }
}
