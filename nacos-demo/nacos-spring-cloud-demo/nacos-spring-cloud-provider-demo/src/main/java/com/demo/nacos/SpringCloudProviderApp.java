package com.demo.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderApp.class, args);
    }

    @GetMapping(value="/{str}")
    public String get(@PathVariable String str){
        return "OK! PathVariable = " + str + " @ " + SpringCloudProviderApp.class;
    }
}
