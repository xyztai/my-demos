package com.demo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tai
 * @create 2021-08-06 14:45
 */
@RestController
public class TestController {

    @GetMapping("demo")
    public String demo(String name){
        return "demo,"+name;
    }

    @GetMapping("hello")
    @SentinelResource(value = "test.hello", fallback = "helloError")
    public String hello(String name){
        return "hello,"+name;
    }

    public String helloError(String name, Throwable e){
        return "error,"+name;
    }

}
