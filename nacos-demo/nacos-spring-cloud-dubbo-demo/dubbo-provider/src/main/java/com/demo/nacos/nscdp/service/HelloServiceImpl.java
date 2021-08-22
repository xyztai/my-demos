package com.demo.nacos.nscdp.service;

import com.demo.nacos.nscdd.service.IHelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Author t
 * @create 2021-08-21 12:32
 */
@Service(interfaceClass=IHelloService.class)
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello(String name) {
        return "dubbo-provider Hello " + name;
    }
}
