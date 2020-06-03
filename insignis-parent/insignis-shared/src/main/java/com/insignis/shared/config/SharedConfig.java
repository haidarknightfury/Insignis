package com.insignis.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.insignis.shared.middleware.CustomRestTemplateCustomizer;

@Configuration
@ComponentScan(value = "com.insignis.shared")
public class SharedConfig {

	@Bean
	public CustomRestTemplateCustomizer customRestTemplateCustomizer() {
		return new CustomRestTemplateCustomizer();
	}

//
//	@Bean
//	@DependsOn(value = { "customRestTemplateCustomizer" })
//	public RestTemplate restTemplate(CustomRestTemplateCustomizer customRestTemplateCustomizer) {
//		RestTemplate restTemplate = new RestTemplateBuilder(customRestTemplateCustomizer).build();
//		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
//		return restTemplate;
//	}

}
