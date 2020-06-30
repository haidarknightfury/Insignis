
package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "cost_price", "discount", "offer", "stock", "description", "image", "rating_count", "store_rating_count", "currency", "bought", "size", "color", "shipping", "rating",
		"store_rating", "store_rate", "sold_by", "specs", "reviews", "store_reviews", "sizing", "buyer_guarantee", "sponsored" })
public class Product implements Serializable {

	@JsonProperty("name")
	private String name;
	@JsonProperty("cost_price")
	private Integer costPrice;
	@JsonProperty("discount")
	private Integer discount;
	@JsonProperty("offer")
	private Boolean offer;
	@JsonProperty("stock")
	private Integer stock;
	@JsonProperty("description")
	private String description;
	@JsonProperty("image")
	private List<String> image = new ArrayList<String>();
	@JsonProperty("rating_count")
	private Integer ratingCount;
	@JsonProperty("store_rating_count")
	private Integer storeRatingCount;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("bought")
	private Integer bought;
	@JsonProperty("size")
	private String size;
	@JsonProperty("color")
	private String color;
	@JsonProperty("shipping")
	private Integer shipping;
	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("store_rating")
	private Integer storeRating;
	@JsonProperty("store_rate")
	private Integer storeRate;
	@JsonProperty("sold_by")
	private String soldBy;
	@JsonProperty("specs")
	private String specs;
	@JsonProperty("reviews")
	private List<Review> reviews = null;
	@JsonProperty("store_reviews")
	private List<StoreReview> storeReviews = null;
	@JsonProperty("sizing")
	private Sizing sizing;
	@JsonProperty("buyer_guarantee")
	private String buyerGuarantee;
	@JsonProperty("sponsored")
	private List<Object> sponsored = null;
	@JsonProperty("category")
	private List<Tab> category;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -4817961994136831708L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Product() {
	}

	/**
	 *
	 * @param sizing
	 * @param image
	 * @param color
	 * @param storeRatingCount
	 * @param storeReviews
	 * @param bought
	 * @param soldBy
	 * @param costPrice
	 * @param rating
	 * @param discount
	 * @param description
	 * @param sponsored
	 * @param ratingCount
	 * @param offer
	 * @param specs
	 * @param size
	 * @param shipping
	 * @param reviews
	 * @param buyerGuarantee
	 * @param name
	 * @param storeRate
	 * @param currency
	 * @param storeRating
	 * @param stock
	 */
	public Product(String name, Integer costPrice, Integer discount, Boolean offer, Integer stock, String description, List<String> image, Integer ratingCount, Integer storeRatingCount,
			String currency, Integer bought, String size, String color, Integer shipping, Integer rating, Integer storeRating, Integer storeRate, String soldBy, String specs, List<Review> reviews,
			List<StoreReview> storeReviews, Sizing sizing, String buyerGuarantee, List<Object> sponsored) {
		super();
		this.name = name;
		this.costPrice = costPrice;
		this.discount = discount;
		this.offer = offer;
		this.stock = stock;
		this.description = description;
		this.image = image;
		this.ratingCount = ratingCount;
		this.storeRatingCount = storeRatingCount;
		this.currency = currency;
		this.bought = bought;
		this.size = size;
		this.color = color;
		this.shipping = shipping;
		this.rating = rating;
		this.storeRating = storeRating;
		this.storeRate = storeRate;
		this.soldBy = soldBy;
		this.specs = specs;
		this.reviews = reviews;
		this.storeReviews = storeReviews;
		this.sizing = sizing;
		this.buyerGuarantee = buyerGuarantee;
		this.sponsored = sponsored;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("cost_price")
	public Integer getCostPrice() {
		return costPrice;
	}

	@JsonProperty("cost_price")
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}

	@JsonProperty("discount")
	public Integer getDiscount() {
		return discount;
	}

	@JsonProperty("discount")
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@JsonProperty("offer")
	public Boolean getOffer() {
		return offer;
	}

	@JsonProperty("offer")
	public void setOffer(Boolean offer) {
		this.offer = offer;
	}

	@JsonProperty("stock")
	public Integer getStock() {
		return stock;
	}

	@JsonProperty("stock")
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("image")
	public List<String> getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(List<String> image) {
		this.image = image;
	}

	@JsonProperty("rating_count")
	public Integer getRatingCount() {
		return ratingCount;
	}

	@JsonProperty("rating_count")
	public void setRatingCount(Integer ratingCount) {
		this.ratingCount = ratingCount;
	}

	@JsonProperty("store_rating_count")
	public Integer getStoreRatingCount() {
		return storeRatingCount;
	}

	@JsonProperty("store_rating_count")
	public void setStoreRatingCount(Integer storeRatingCount) {
		this.storeRatingCount = storeRatingCount;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("bought")
	public Integer getBought() {
		return bought;
	}

	@JsonProperty("bought")
	public void setBought(Integer bought) {
		this.bought = bought;
	}

	@JsonProperty("size")
	public String getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(String size) {
		this.size = size;
	}

	@JsonProperty("color")
	public String getColor() {
		return color;
	}

	@JsonProperty("color")
	public void setColor(String color) {
		this.color = color;
	}

	@JsonProperty("shipping")
	public Integer getShipping() {
		return shipping;
	}

	@JsonProperty("shipping")
	public void setShipping(Integer shipping) {
		this.shipping = shipping;
	}

	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@JsonProperty("store_rating")
	public Integer getStoreRating() {
		return storeRating;
	}

	@JsonProperty("store_rating")
	public void setStoreRating(Integer storeRating) {
		this.storeRating = storeRating;
	}

	@JsonProperty("store_rate")
	public Integer getStoreRate() {
		return storeRate;
	}

	@JsonProperty("store_rate")
	public void setStoreRate(Integer storeRate) {
		this.storeRate = storeRate;
	}

	@JsonProperty("sold_by")
	public String getSoldBy() {
		return soldBy;
	}

	@JsonProperty("sold_by")
	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	@JsonProperty("specs")
	public String getSpecs() {
		return specs;
	}

	@JsonProperty("specs")
	public void setSpecs(String specs) {
		this.specs = specs;
	}

	@JsonProperty("reviews")
	public List<Review> getReviews() {
		return reviews;
	}

	@JsonProperty("reviews")
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@JsonProperty("store_reviews")
	public List<StoreReview> getStoreReviews() {
		return storeReviews;
	}

	@JsonProperty("store_reviews")
	public void setStoreReviews(List<StoreReview> storeReviews) {
		this.storeReviews = storeReviews;
	}

	@JsonProperty("sizing")
	public Sizing getSizing() {
		return sizing;
	}

	@JsonProperty("sizing")
	public void setSizing(Sizing sizing) {
		this.sizing = sizing;
	}

	@JsonProperty("buyer_guarantee")
	public String getBuyerGuarantee() {
		return buyerGuarantee;
	}

	@JsonProperty("buyer_guarantee")
	public void setBuyerGuarantee(String buyerGuarantee) {
		this.buyerGuarantee = buyerGuarantee;
	}

	@JsonProperty("sponsored")
	public List<Object> getSponsored() {
		return sponsored;
	}

	@JsonProperty("sponsored")
	public void setSponsored(List<Object> sponsored) {
		this.sponsored = sponsored;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonProperty("category")
	public List<Tab> getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(List<Tab> category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("costPrice", costPrice).append("discount", discount).append("offer", offer).append("stock", stock)
				.append("description", description).append("image", image).append("ratingCount", ratingCount).append("storeRatingCount", storeRatingCount).append("currency", currency)
				.append("bought", bought).append("size", size).append("color", color).append("shipping", shipping).append("rating", rating).append("storeRating", storeRating)
				.append("storeRate", storeRate).append("soldBy", soldBy).append("specs", specs).append("reviews", reviews).append("storeReviews", storeReviews).append("sizing", sizing)
				.append("buyerGuarantee", buyerGuarantee).append("sponsored", sponsored).append("additionalProperties", additionalProperties).toString();
	}

}
