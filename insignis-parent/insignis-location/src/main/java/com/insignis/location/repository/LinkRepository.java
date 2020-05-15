package com.insignis.location.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.insignis.location.model.Link;

public interface LinkRepository extends Neo4jRepository<Link, Long> {

}
