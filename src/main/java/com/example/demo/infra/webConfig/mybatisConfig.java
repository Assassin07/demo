package com.example.demo.infra.webConfig;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;


import com.example.demo.infra.Interceptor.mybatis;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class mybatisConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

        // 自定义拦截器，先添加先执行。
        interceptor.addInnerInterceptor(new mybatis());
        // 自带分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
    }
