package com.insignis.shared.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.insignis.shared.middleware.CustomRestTemplateCustomizer;

@Configuration
public class SharedConfig {

	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
		return new CustomRestTemplateCustomizer();
	}

	@Bean
	@DependsOn(value = { "customRestTemplateCustomizer" })
	public RestTemplate restTemplate(CustomRestTemplateCustomizer customRestTemplateCustomizer) {
		RestTemplate restTemplate =  new RestTemplateBuilder(customRestTemplateCustomizer).build();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		return restTemplate;
	}

}
