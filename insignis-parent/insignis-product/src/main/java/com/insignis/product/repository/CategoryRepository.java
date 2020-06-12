package com.insignis.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.insignis.product.domain.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

	public Category findByCategory(String category);

	public Boolean existsByCategory(String category);
}
