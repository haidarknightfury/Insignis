package com.insignis.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class CartDTO implements Serializable {

	private static final long serialVersionUID = 7723057410812026224L;
	private String id;
	private BigDecimal total;
	private List<ProductDTO> products;
	private String customerId;
	private String outlet;
	private Date date;

	public CartDTO() {
	}

	public CartDTO(String id, BigDecimal total, List<ProductDTO> products, String customerId, String outlet, Date date) {
		super();
		this.id = id;
		this.total = total;
		this.products = products;
		this.customerId = customerId;
		this.outlet = outlet;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOutlet() {
		return outlet;
	}

	public void setOutlet(String outlet) {
		this.outlet = outlet;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
