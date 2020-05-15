package com.insignis.location.model;

public enum CategoryEnum {

	FOOD("General FoodStuffs"), SANITARY("Sanitary products"), DAIRY("Dairy products"), NOT_DEFINED("Not Defined");

	private final String description;

	private CategoryEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	};

}
