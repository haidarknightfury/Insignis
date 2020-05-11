package com.insignis.payment.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
public class Payment {

	@Id
	private String id;
	private String description;
	private BigDecimal amount;
	private String cartId;

}
