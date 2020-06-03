package com.insignis.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.insignis.shared.config.SharedConfig;

@EnableDiscoveryClient
@SpringBootApplication
@Import(SharedConfig.class)
public class InsignisCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsignisCartApplication.class, args);
	}
}
