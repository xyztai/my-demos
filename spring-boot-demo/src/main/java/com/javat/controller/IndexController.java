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
        return "Welcome Here!";
    }
}