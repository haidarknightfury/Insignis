package com.insignis.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -2627578397728767249L;
	private String id;
	private String productId;
	private String name;
	private Float unitPrice;
	private List<CategoryDTO> categories;
	private SupplierDTO supplier;

	public ProductDTO(String id, String productId, String name, Float unitPrice, List<CategoryDTO> categories, SupplierDTO supplier) {
		super();
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.categories = categories;
		this.supplier = supplier;
	}

	public ProductDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", categories=" + categories + ", supplier=" + supplier + "]";
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
		this.supplier = supplier;
	}

}
