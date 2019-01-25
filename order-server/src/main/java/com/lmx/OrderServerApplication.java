package com.lmx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class OrderServerApplication {
    @Configuration
    class MyConfiguration {

        @LoadBalanced
        @Bean
        RestTemplate restTemplate() {
            // 默认 RestTemplate 是无负载功能的，所以我们需要重新定义 RestTemplate 申请成 @LoadBalanced（默认情况是轮训）
            return new RestTemplate();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }


}

