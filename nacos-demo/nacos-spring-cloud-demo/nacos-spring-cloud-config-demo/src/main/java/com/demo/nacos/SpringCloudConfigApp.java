package com.demo.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RefreshScope
public class SpringCloudConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigApp.class, args);
    }

    @Value("${a.b:false}")
    private boolean userLocalCache;

    @GetMapping("/getConfig")
    public boolean get(){
        return userLocalCache;
    }
}
