package com.insignis.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String id;

	@NotNull(message = "Product Id must not be null")
	private String productId;

	@NotNull(message = "Supplier Id must not be null")
	private String supplierId;

	private Float unitPrice;

	@DBRef
	private List<Category> categories = new ArrayList<Category>();

	public Product(String id, @NotNull(message = "Product Id must not be null") String productId,
			@NotNull(message = "Supplier Id must not be null") String supplierId, Float unitPrice,
			List<Category> categories) {
		super();
		this.id = id;
		this.productId = productId;
		this.supplierId = supplierId;
		this.unitPrice = unitPrice;
		this.categories = categories;
	}

	public Product() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	

}
