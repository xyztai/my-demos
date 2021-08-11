package com.demo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.demo.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tai
 * @create 2021-08-06 17:02
 */
@RestController
public class TestController {

    @Autowired
    private TestService service;

    @GetMapping(value = "/block")
    public String sayBlock() {
        return "Hello, CHINA";
    }


    @GetMapping(value = "/demo/{name}")
    public String demo(@PathVariable String name) {
        return "demo, " + name;
    }


    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }

    @GetMapping("hello")
    @SentinelResource(value = "test.hello", fallback = "helloError")
    public String hello(String name){
        return "hello,"+name;
    }
}
