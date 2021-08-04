package com.javat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

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

    @Autowired
    private DataSource c3p0DataSource;

    @GetMapping("/c3p0")
    public String getC3P0() throws SQLException {
        return String.valueOf(c3p0DataSource.getConnection());
    }
}