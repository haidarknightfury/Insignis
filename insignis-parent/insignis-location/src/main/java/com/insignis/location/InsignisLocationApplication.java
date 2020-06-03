package com.insignis.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InsignisLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsignisLocationApplication.class, args);
	}
}
