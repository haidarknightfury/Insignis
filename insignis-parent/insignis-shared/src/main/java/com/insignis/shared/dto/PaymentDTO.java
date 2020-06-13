package com.insignis.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentDTO implements Serializable {

	private static final long serialVersionUID = -8438189077615293458L;
	private String id;
	private String chargeId;
	private String balanceTransactionId;
	private String description;
	private BigDecimal amount;
	private String paymentMethod;
	private String cartId;
	private String status;
	private String currency;
	private Date date;

	public PaymentDTO(String id, String chargeId, String balanceTransactionId, String description, BigDecimal amount, String paymentMethod, String cartId, String status, String currency, Date date) {
		super();
		this.id = id;
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

	public PaymentDTO() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
