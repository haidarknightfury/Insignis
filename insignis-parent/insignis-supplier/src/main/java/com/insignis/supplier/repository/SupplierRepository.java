package com.insignis.supplier.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.insignis.supplier.domain.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

}
