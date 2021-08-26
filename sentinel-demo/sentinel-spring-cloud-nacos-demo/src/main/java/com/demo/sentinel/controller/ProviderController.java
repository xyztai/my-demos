package com.demo.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.demo.sentinel.service.SentinelResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tai
 * @create 2021-08-06 17:02
 */
@RestController
@RefreshScope
public class ProviderController {

    @Autowired
    private SentinelResourceService service;

    @Value("${params.animal:human}")
    private String animal;

    @GetMapping(value = "/block")
    public String sayBlock() {
        return "Hello, CHINA";
    }


    @GetMapping(value = "/demo/{name}")
    public String demo(@PathVariable String name) {
        return "demo, " + name + " [human] => " + animal;
    }


    @GetMapping(value = "/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }

    @GetMapping("hello")
    @SentinelResource(value = "test.hello", fallback = "helloError")
    public String hello(String name){
        return "hello,"+name;
    }

    @GetMapping(value = "/provider/{name}")
    public String provider(@PathVariable String name) {
        return "from provider: " + name;
    }
}
