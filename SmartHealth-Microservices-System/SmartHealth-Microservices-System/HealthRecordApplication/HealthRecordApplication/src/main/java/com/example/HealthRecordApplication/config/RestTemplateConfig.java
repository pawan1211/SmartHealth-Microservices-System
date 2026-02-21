package com.example.HealthRecordApplication.config;


import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced   // 🔥 Important for Eureka
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}