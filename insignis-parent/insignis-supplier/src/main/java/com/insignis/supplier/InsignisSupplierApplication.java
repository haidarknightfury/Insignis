package com.insignis.supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InsignisSupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsignisSupplierApplication.class, args);
	}
}
