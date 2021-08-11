package com.demo.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author tai
 * @create 2021-08-06 14:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApp {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApp.class, args);
    }
}
