package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "product", "amount", "billing_address", "shipping_address", "delivery_date", "id", "order_date", "status", "tax" })
public class Order implements Serializable {

	@JsonProperty("product")
	private Product product;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("billing_address")
	private Address billingAddress;
	@JsonProperty("shipping_address")
	private Address shippingAddress;
	@JsonProperty("delivery_date")
	private String deliveryDate;
	@JsonProperty("id")
	private String id;
	@JsonProperty("order_date")
	private String orderDate;
	@JsonProperty("status")
	private String status;
	@JsonProperty("tax")
	private Integer tax;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 1904087544537398734L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Order() {
	}

	/**
	 *
	 * @param product
	 * @param amount
	 * @param shippingAddress
	 * @param tax
	 * @param billingAddress
	 * @param id
	 * @param deliveryDate
	 * @param orderDate
	 * @param status
	 */
	public Order(Product product, Integer amount, Address billingAddress, Address shippingAddress, String deliveryDate, String id, String orderDate, String status, Integer tax) {
		super();
		this.product = product;
		this.amount = amount;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
		this.deliveryDate = deliveryDate;
		this.id = id;
		this.orderDate = orderDate;
		this.status = status;
		this.tax = tax;
	}

	@JsonProperty("product")
	public Product getProduct() {
		return product;
	}

	@JsonProperty("product")
	public void setProduct(Product product) {
		this.product = product;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("billing_address")
	public Address getBillingAddress() {
		return billingAddress;
	}

	@JsonProperty("billing_address")
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@JsonProperty("shipping_address")
	public Address getShippingAddress() {
		return shippingAddress;
	}

	@JsonProperty("shipping_address")
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@JsonProperty("delivery_date")
	public String getDeliveryDate() {
		return deliveryDate;
	}

	@JsonProperty("delivery_date")
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("order_date")
	public String getOrderDate() {
		return orderDate;
	}

	@JsonProperty("order_date")
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("tax")
	public Integer getTax() {
		return tax;
	}

	@JsonProperty("tax")
	public void setTax(Integer tax) {
		this.tax = tax;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("product", product).append("amount", amount).append("billingAddress", billingAddress).append("shippingAddress", shippingAddress)
				.append("deliveryDate", deliveryDate).append("id", id).append("orderDate", orderDate).append("status", status).append("tax", tax).append("additionalProperties", additionalProperties)
				.toString();
	}

}