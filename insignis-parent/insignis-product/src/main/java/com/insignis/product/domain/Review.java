package com.insignis.product.domain;

import java.util.ArrayList;
import java.util.List;

public class Review {

	private String image;
	private String name;
	private String comment;
	private String rating;
	private List<String> images = new ArrayList<>();

	public Review(String image, String name, String comment, String rating, List<String> images) {
		super();
		this.image = image;
		this.name = name;
		this.comment = comment;
		this.rating = rating;
		this.images = images;
	}

	public Review() {
		super();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Review [image=" + image + ", name=" + name + ", comment=" + comment + ", rating=" + rating + ", images=" + images + "]";
	}

}
