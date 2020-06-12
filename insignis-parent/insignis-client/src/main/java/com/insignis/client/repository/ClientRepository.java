package com.insignis.client.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insignis.client.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {

	Optional<Client> findByLastNameOrFirstNameIgnoreCase(String name);

}
