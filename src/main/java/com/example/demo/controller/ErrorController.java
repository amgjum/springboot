//package com.example.demo.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Collections;
//import java.util.Map;
//
//@Controller
//public class ErrorController extends AbstractErrorController {
//    Logger l = LoggerFactory.getLogger(ErrorController.class);
//
//
//    public ErrorController() {
//        super(new DefaultErrorAttributes());
//    }
//
//    @RequestMapping("/error")
////    @Override
//    public String getErrorPath(HttpServletRequest req, HttpServletResponse res) {
//        Map<String,Object> model = Collections.unmodifiableMap(getErrorAttributes(req,false));
//        //Throwable cause = getCause
//        return null;
//    }
//}
