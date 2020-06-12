package com.insignis.payment.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.insignis.payment.service.ChargeRequest.Currency;

@Document(collection = "payment")
public class Payment {

	@Id
	private String id;
	private String description;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String cartId;
	private String status;
	private Currency currency;
	private Date date;

	public Payment(String description, BigDecimal amount, PaymentMethod paymentMethod, String cartId, String status, Currency currency, Date date) {
		super();
		this.description = description;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.cartId = cartId;
		this.status = status;
		this.currency = currency;
		this.date = date;
	}

	public Payment() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

}
