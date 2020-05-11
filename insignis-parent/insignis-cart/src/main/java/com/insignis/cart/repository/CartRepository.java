package com.insignis.cart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insignis.cart.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {

}
