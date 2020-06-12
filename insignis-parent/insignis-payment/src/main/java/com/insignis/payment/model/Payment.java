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
	private String chargeId;
	private String balanceTransactionId;
	private String description;
	private BigDecimal amount;
	private PaymentMethod paymentMethod;
	private String cartId;
	private String status;
	private Currency currency;
	private Date date;

	public Payment(String chargeId, String balanceTransactionId, String description, BigDecimal amount, PaymentMethod paymentMethod, String cartId, String status, Currency currency, Date date) {
		this.chargeId = chargeId;
		this.balanceTransactionId = balanceTransactionId;
		this.description = description;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.cartId = cartId;
		this.status = status;
		this.currency = currency;
		this.date = date;
	}

	public Payment() {
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

	public String getChargeId() {
		return chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public String getBalanceTransactionId() {
		return balanceTransactionId;
	}

	public void setBalanceTransactionId(String balanceTransactionId) {
		this.balanceTransactionId = balanceTransactionId;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
