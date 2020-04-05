package com.insignis.supplier.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.insignis.supplier.domain.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

	Optional<Supplier> findByNameIgnoreCase(String name);
}
