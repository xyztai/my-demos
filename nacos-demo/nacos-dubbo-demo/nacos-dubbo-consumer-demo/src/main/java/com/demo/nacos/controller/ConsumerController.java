package com.demo.nacos.controller;

import com.demo.nacos.IHelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @DubboReference
    private IHelloService helloService;

    // http://127.0.0.1:10001/CHINA
    @GetMapping("/{str}")
    public String consumer(@PathVariable String str){
        return helloService.sayHello(str);
    }
}
