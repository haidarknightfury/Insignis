package com.insignis.recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class InsignisRecommenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsignisRecommenderApplication.class, args);
	}
}
