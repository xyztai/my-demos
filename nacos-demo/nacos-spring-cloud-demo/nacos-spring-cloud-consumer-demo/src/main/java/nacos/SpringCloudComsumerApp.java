package nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudComsumerApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudComsumerApp.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RestController
    public class TestController{
        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        // http://127.0.0.1:13001/test/CHINA
        @GetMapping(value = "/test/{str}")
        public String test(@PathVariable String str){
            return restTemplate.getForObject("http://nacos-spring-cloud-provider-demo/echo/" + str, String.class);
        }
    }
}
