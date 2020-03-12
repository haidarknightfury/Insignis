package com.insignis.product.domain;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {

	@Id
	private String id;

	private CategoryTypeEnum category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CategoryTypeEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryTypeEnum category) {
		this.category = category;
	}

}
