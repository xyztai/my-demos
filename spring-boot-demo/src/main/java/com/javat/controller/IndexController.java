package com.javat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author t
 * @create 2021-07-28 23:42
 */
@RestController
public class IndexController {
    @GetMapping("")
    public String index(){
        return "Welcome spring-boot-demo!";
    }

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("/error-1")
    public String error() throws Exception {
        throw new Exception("error occurs!");
    }
}