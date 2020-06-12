package com.insignis.product.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.insignis.product.config.Constants;

@Document(collection = "product")
@CompoundIndexes({ @CompoundIndex(name = "product_index", def = "{'productId':1, 'name':1}", unique = true) })
public class Product {

	@Id
	private String id;
	@NotNull(message = "Product Id must not be null")
	private String productId;
	@NotNull
	private String name;

	@DBRef
	private List<Category> categories = new ArrayList<Category>();

	@NotNull(message = "Supplier Id must not be null")
	private String supplierId;

	private Boolean offer;
	private String size;
	private String color;

	private Float buyingPrice;
	private Float unitPrice;
	private Float discount;

	private Integer stock;
	private Integer bought;
	private String description;
	private List<String> image;
	private String currency;
	private String specs;

	private String buyerGuarantee;
	private List<Review> reviews = new ArrayList<Review>();
	private List<Review> storeReviews = new ArrayList<Review>();

	public Product(@NotNull(message = "Product id must not be null") String productId, @NotNull String name, @NotNull(message = "Supplier Id must not be null") String supplierId, Float unitPrice,
			List<Category> categories, Float buyingPrice) {
		this.productId = productId;
		this.name = name;
		this.supplierId = supplierId;
		this.unitPrice = unitPrice;
		this.buyingPrice = buyingPrice;
		this.categories = categories;
		this.currency = Constants.CURRENCY;
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

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getStoreReviews() {
		return storeReviews;
	}

	public void setStoreReviews(List<Review> storeReviews) {
		this.storeReviews = storeReviews;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productId=" + productId + ", name=" + name + ", supplierId=" + supplierId + ", unitPrice=" + unitPrice + ", categories=" + categories + "]";
	}

}
