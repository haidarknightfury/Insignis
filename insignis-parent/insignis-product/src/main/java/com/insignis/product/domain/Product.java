package com.insignis.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@CompoundIndexes({ @CompoundIndex(name = "product_index", def = "{'productId':1, 'name':1}", unique = true) })
public class Product {

	@Id
	private String id;

	@NotNull(message = "Product Id must not be null")
	private String productId;

	@NotNull
	private String name;

	@NotNull(message = "Supplier Id must not be null")
	private String supplierId;

	private Float unitPrice;

	@DBRef
	private List<Category> categories = new ArrayList<Category>();

	public Product(@NotNull(message = "Product id must not be null") String productId, @NotNull String name, @NotNull(message = "Supplier Id must not be null") String supplierId, Float unitPrice,
			List<Category> categories) {
		this.productId = productId;
		this.name = name;
		this.supplierId = supplierId;
		this.unitPrice = unitPrice;
		this.categories = categories;
	}

	public Product() {
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", supplierId=" + supplierId + ", unitPrice=" + unitPrice + ", categories=" + categories + "]";
	}

}
