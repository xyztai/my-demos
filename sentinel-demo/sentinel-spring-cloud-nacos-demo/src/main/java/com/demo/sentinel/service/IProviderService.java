package com.demo.sentinel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author tai
 * @create 2021-08-26 11:32
 */
@FeignClient("spring-cloud-demo-p")
public interface IProviderService {

    @GetMapping("/provider/{name}")
    public String echo(@PathVariable(value="name") String name);
}
