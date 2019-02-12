package com.example.demo.config;

import com.example.demo.interception.SessionHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration

public class MvcConfig  implements WebMvcConfigurer {

    //拦截器
    public void addInterceptors(InterceptorRegistry registry){
        SessionHandlerInterceptor sh = new SessionHandlerInterceptor();
        //InterceptorRegistration is = registry.addInterceptor(sh);
        //is.addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login").excludePathPatterns("/error");

        //is.excludePathPatterns("/css/**");



    }

    //跨域访问配置
//    public void addCorsMappings(CorsRegistry registry)
//    {
//
//    }

    //格式化,url映射为controller方法上，日期不会自动转化为date类型
    public void addFormatters(FormatterRegistry registry){
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));

    }

    //url到视图的映射,直接映射到视图

    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("index.h").setViewName("index.html");
//        registry.addRedirectViewController("/**/*.do","/index.html");


    }

    //设置跨域，公开允许跨域的api接口
     @Override
      public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**");
        registry.addMapping("/jpacros/**");

     }

    //....


}
