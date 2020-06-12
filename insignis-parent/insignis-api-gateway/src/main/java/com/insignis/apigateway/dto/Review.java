package com.insignis.apigateway.dto;

import java.io.Serializable;
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
@JsonPropertyOrder({ "image", "name", "comment", "rating", "images" })
public class Review implements Serializable {

	@JsonProperty("image")
	private String image;
	@JsonProperty("name")
	private String name;
	@JsonProperty("comment")
	private String comment;
	@JsonProperty("rating")
	private Integer rating;
	@JsonProperty("images")
	private List<String> images = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 8242123837346032600L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Review() {
	}

	/**
	 *
	 * @param image
	 * @param images
	 * @param name
	 * @param rating
	 * @param comment
	 */
	public Review(String image, String name, String comment, Integer rating, List<String> images) {
		super();
		this.image = image;
		this.name = name;
		this.comment = comment;
		this.rating = rating;
		this.images = images;
	}

	@JsonProperty("image")
	public String getImage() {
		return image;
	}

	@JsonProperty("image")
	public void setImage(String image) {
		this.image = image;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}

	@JsonProperty("rating")
	public Integer getRating() {
		return rating;
	}

	@JsonProperty("rating")
	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@JsonProperty("images")
	public List<String> getImages() {
		return images;
	}

	@JsonProperty("images")
	public void setImages(List<String> images) {
		this.images = images;
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
		return new ToStringBuilder(this).append("image", image).append("name", name).append("comment", comment).append("rating", rating).append("images", images)
				.append("additionalProperties", additionalProperties).toString();
	}

}