package com.insignis.apigateway.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "product", "quantity" })
class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("product")
	private Product product;
	@JsonProperty("quantity")
	private Integer quantity;

	public CartItem() {
	}

	public CartItem(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	@JsonProperty("product")
	public Product getProduct() {
		return product;
	}

	@JsonProperty("product")
	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}