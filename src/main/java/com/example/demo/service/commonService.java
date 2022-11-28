package com.example.demo.service;

import com.example.demo.DTO.testDTO;
import com.example.demo.infra.untils.LogUtil;
import com.example.demo.infra.untils.ThreadLocalUntils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class commonService {

    public void common() {
        testDTO testDTO = ThreadLocalUntils.getThreadLocal().get();
        String stackTrace = LogUtil.getStackTrace();
        System.out.println("common");
    }
}
