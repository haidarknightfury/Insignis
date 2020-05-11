package com.insignis.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartDTO implements Serializable {

	private static final long serialVersionUID = 7723057410812026224L;
	private String id;
	private BigDecimal total;
	private List<ProductDTO> products;

	public CartDTO() {
	}

	public CartDTO(String id, BigDecimal total, List<ProductDTO> products) {
		this.id = id;
		this.total = total;
		this.products = products;
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

}
