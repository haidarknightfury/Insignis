package com.insignis.location.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.insignis.location")
@EntityScan(basePackages = "com.insignis.location.model")
@EnableTransactionManagement
public class Neo4jConfiguration {

}
