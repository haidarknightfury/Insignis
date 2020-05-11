package com.insignis.payment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.insignis.payment")
public class MongoConfig {

	private final MongoTemplate mongoTemplate;
	private final MongoConverter mongoConverter;

	@Autowired
	public MongoConfig(MongoTemplate mongoTemplate, MongoConverter mongoConverter) {
		this.mongoTemplate = mongoTemplate;
		this.mongoConverter = mongoConverter;
	}
}