package com.demo.nacos.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author t
 * @create 2021-08-02 22:54
 */
@RestController
public class DemoController {

    @NacosValue(value="${paras.isExists:false}", autoRefreshed = true)
    private boolean isExists;

    @NacosValue(value="${paras.animal:ddddd}", autoRefreshed = true)
    private String animal;

    @NacosInjected
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
