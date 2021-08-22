package com.demo.nacos.nscdc.controller;

import com.demo.nacos.nscdd.service.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author t
 * @create 2021-08-22 23:00
 */
@RestController
public class HelloController {
    @Reference(check=false, interfaceClass=IHelloService.class)
    private IHelloService helloService;

    @GetMapping("/{str}")
    public String hello(@PathVariable("str") String str) {
        return helloService.hello(str);
    }
}
