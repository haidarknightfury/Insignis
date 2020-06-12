package com.insignis.payment.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfigClient {

	@Bean(name = "paymentRestTemplate")
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
