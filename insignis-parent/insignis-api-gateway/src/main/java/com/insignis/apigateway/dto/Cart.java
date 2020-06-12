package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {

	private static final long serialVersionUID = -3838660435704018388L;
	private List<CartItem> cartItems;

	public Cart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public Cart() {
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

}
