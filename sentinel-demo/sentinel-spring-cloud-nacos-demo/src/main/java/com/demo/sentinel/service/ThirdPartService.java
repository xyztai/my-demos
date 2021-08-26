package com.demo.sentinel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author tai
 * @create 2021-08-26 13:51
 */
@Service
public class ThirdPartService {

    @Autowired
    private IProviderService providerService;

    public String getEcho(String name){
        return "providerService: " + providerService.echo(name);
    }
}
