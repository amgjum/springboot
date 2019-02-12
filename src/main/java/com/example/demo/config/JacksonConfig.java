package com.example.demo.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class JacksonConfig {


    //自定义objectMapper类，其中对于时间进行了重新定义格式
//    @Bean
//    public ObjectMapper getObjectMapper(){
//
//        ObjectMapper oj = new ObjectMapper();
//        oj.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
//        return oj;
//    }
}
