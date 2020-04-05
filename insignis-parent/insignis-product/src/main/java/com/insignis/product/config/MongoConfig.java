package com.insignis.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.insignis.product.domain.Product;

@Configuration
@EnableMongoRepositories(basePackages = "com.insignis.product")
public class MongoConfig {

	private final MongoTemplate mongoTemplate;
	private final MongoConverter mongoConverter;

	@Autowired
	public MongoConfig(MongoTemplate mongoTemplate, MongoConverter mongoConverter) {
		this.mongoTemplate = mongoTemplate;
		this.mongoConverter = mongoConverter;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void initIndicesAfterStartup() {
		IndexOperations indexOps = mongoTemplate.indexOps(Product.class);
		IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoConverter.getMappingContext());
		resolver.resolveIndexFor(Product.class).forEach(indexOps::ensureIndex);
	}

}
