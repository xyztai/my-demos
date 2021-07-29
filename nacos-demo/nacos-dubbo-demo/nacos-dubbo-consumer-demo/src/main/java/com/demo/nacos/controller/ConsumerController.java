package com.demo.nacos.controller;

import com.demo.nacos.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @DubboReference
    private IHelloService helloService;

    @GetMapping("/hello")
    public String consumer(@RequestParam String str){
        return helloService.sayHello(str);
    }
}
