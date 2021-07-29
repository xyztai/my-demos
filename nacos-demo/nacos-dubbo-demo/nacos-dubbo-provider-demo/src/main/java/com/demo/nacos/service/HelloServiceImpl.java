package com.demo.nacos.service;

import com.demo.nacos.IHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

// dubbo 注解，暴露服务
@DubboService
@Component
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String str) {
        return str + " come from provider!";
    }
}
