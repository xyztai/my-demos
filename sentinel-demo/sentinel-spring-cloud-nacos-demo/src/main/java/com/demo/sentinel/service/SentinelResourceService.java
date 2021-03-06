package com.demo.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @Author tai
 * @create 2021-08-06 17:01
 */
@Service
public class SentinelResourceService {

    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sayHello, " + name;
    }
}