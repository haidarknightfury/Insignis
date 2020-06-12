package com.insignis.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CheckoutDTO implements Serializable {

	private static final long serialVersionUID = -383458660596276833L;
	private String id;
	private String description;
	private BigDecimal amount;
	private String paymentMethod;
	private String cartId;
	private String status;
	private String currency;
	private Date date;

	public CheckoutDTO() {
		super();
	}

	public CheckoutDTO(String id, String description, BigDecimal amount, String paymentMethod, String cartId, String status, String currency, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.cartId = cartId;
		this.status = status;
		this.currency = currency;
		this.date = date;
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
