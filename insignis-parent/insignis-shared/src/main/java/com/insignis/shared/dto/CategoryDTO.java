package com.insignis.shared.dto;

public class CategoryDTO {

	private String id;
	private String category;

	public CategoryDTO(String id, String category) {
		super();
		this.id = id;
		this.category = category;
	}

	public CategoryDTO() {
		super();
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", category=" + category + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
