package com.insignis.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = -2627578397728767249L;
	private String id;
	private String productId;
	private String name;
	private Float unitPrice;
	private Integer quantity;
	private List<CategoryDTO> categories;
	private SupplierDTO supplier;

	private Boolean offer;
	private String size;
	private String color;
	private Float buyingPrice;
	private Float discount;

	private Integer stock;
	private Integer bought;
	private String description;
	private List<String> image;
	private String currency;
	private String specs;
	private String buyerGuarantee;
	private List<ReviewDTO> reviews;
	private List<ReviewDTO> storeReviews;

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getOffer() {
		return offer;
	}

	public void setOffer(Boolean offer) {
		this.offer = offer;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Float getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(Float buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getBought() {
		return bought;
	}

	public void setBought(Integer bought) {
		this.bought = bought;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String getBuyerGuarantee() {
		return buyerGuarantee;
	}

	public void setBuyerGuarantee(String buyerGuarantee) {
		this.buyerGuarantee = buyerGuarantee;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

	public List<ReviewDTO> getStoreReviews() {
		return storeReviews;
	}

	public void setStoreReviews(List<ReviewDTO> storeReviews) {
		this.storeReviews = storeReviews;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", productId=" + productId + ", name=" + name + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", categories=" + categories + ", supplier=" + supplier
				+ "]";
	}

}
