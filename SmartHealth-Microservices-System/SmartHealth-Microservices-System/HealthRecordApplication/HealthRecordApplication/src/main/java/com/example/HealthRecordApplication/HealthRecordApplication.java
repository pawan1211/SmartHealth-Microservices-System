package com.example.HealthRecordApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HealthRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthRecordApplication.class, args);
	}

}
