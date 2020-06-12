package com.insignis.payment.service;

public class ChargeRequest {

	public enum Currency {
		EUR, USD, MUR;
	}

	private String cartId;
	private String description;
	private int amount; // cents
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;

	public ChargeRequest(String description, int amount, Currency currency, String stripeEmail, String stripeToken, String cartId) {
		super();
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.stripeEmail = stripeEmail;
		this.stripeToken = stripeToken;
		this.cartId = cartId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String getStripeEmail() {
		return stripeEmail;
	}

	public void setStripeEmail(String stripeEmail) {
		this.stripeEmail = stripeEmail;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	@Override
	public String toString() {
		return "ChargeRequest [cartId=" + cartId + ", description=" + description + ", amount=" + amount + ", currency=" + currency + ", stripeEmail=" + stripeEmail + ", stripeToken=" + stripeToken
				+ "]";
	}

}