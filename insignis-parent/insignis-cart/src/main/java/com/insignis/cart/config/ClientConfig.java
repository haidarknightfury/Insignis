package com.insignis.cart.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

	@Bean(name = "cartRestTemplate")
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
