package com.insignis.apigateway.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insignis.apigateway.model.Role;
import com.insignis.apigateway.model.RoleEnum;

public interface RoleRepository extends MongoRepository<Role, String> {

	Optional<Role> findByName(RoleEnum name);
}
