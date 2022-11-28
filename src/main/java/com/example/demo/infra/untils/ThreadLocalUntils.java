package com.example.demo.infra.untils;

import com.example.demo.DTO.testDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
//只是想用下bean销毁
@Component
public class ThreadLocalUntils {
    //保证单例
    private ThreadLocalUntils(){ }
    private static final ThreadLocal<testDTO> threadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Map> threadLocalMap = new ThreadLocal<>();

    //设置线程变量
    public static ThreadLocal<testDTO> getThreadLocal() {
        return threadLocal;
    }
    //添加线程变量
//    public static void setThreadLocal(String key, Object value) {
//        threadLocal.get().put(key, value);
//    }
    //移除线程变量
    public static void remove() {
        threadLocal.remove();
    }
    public static ThreadLocal<Map> getThreadLocaltest() {
        return threadLocalMap;
    }
    public static Map getThreadLocalMap() {
        return threadLocalMap.get();
    }
}
