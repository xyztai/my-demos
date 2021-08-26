package com.demo.sentinel.controller;

import com.demo.sentinel.service.ThirdPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tai
 * @create 2021-08-06 17:02
 */
@RestController
public class ConsumerController {

    @Autowired
    private ThirdPartService thirdPartService;

    @GetMapping(value = "/consumer/{name}")
    public String consumer(@PathVariable String name) {
        return "thirdPartService: " + thirdPartService.getEcho(name);
    }
}
