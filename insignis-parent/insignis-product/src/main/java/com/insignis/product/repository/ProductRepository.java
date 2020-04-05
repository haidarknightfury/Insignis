package com.insignis.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.insignis.product.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	public Product findByName(String name);

	public Product findByProductId(String productId);

}
