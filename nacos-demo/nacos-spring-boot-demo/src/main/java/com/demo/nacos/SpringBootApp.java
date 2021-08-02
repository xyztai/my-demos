package com.demo.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySources;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@EnableNacosDiscovery
//@EnableNacosDiscovery
//@NacosPropertySources(value = {
//        @NacosPropertySource(dataId = "z-a.yml", groupId = "platform_group", autoRefreshed = true),
//        @NacosPropertySource(dataId = "z-b.yml", groupId = "platform_group", autoRefreshed = true),
//})
//@NacosPropertySource(dataId = "z-a.yml", groupId = "platform_group", autoRefreshed = true)
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @NacosValue(value="${paras.isExists:false}", autoRefreshed = true)
    private boolean isExists;

    @NacosValue(value="${paras.animal:ddddd}", autoRefreshed = true)
    private String animal;

    //@NacosInjected
    private NamingService namingService;

    // http://127.0.0.1:18001/test/getConfig
    @GetMapping(value = "/getConfig")
    public String Hello(){
        return "nacos-spring-boot-demo: " + isExists + " " + animal;
    }

    // http://127.0.0.1:18001/test/getInstance?serviceName=nacos-spring-boot-demo&groupName=DEFAULT_GROUP
    @GetMapping(value = "/getInstance")
    public List<Instance> get(@RequestParam String serviceName, @RequestParam String groupName) throws NacosException {
        return namingService.getAllInstances(serviceName, groupName);
    }
}
