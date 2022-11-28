package com.example.demo.infra.repository;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Map;
@Mapper
public interface testMapper extends BaseMapper<Map> {
     Map<String,String> test();
}
