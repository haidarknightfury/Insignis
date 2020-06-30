package com.insignis.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.insignis.product.domain.Category;
import com.insignis.product.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	public Optional<Product> findByNameIgnoreCase(String name);

	public Product findByProductId(String productId);

	public boolean existsById(String productId);

	public List<Product> findByCategoriesIn(List<Category> categories);

}
