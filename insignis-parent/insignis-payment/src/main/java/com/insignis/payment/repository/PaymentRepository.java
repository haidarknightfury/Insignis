package com.insignis.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.insignis.payment.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {

}
