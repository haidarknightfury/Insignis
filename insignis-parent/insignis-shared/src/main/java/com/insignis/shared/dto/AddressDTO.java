package com.insignis.shared.dto;

public class AddressDTO {
	private String id;
	private String street;
	private String region;
	private String country;
	private Integer postalCode;

	public AddressDTO(String street, String region, String country, Integer postalCode) {
		super();
		this.street = street;
		this.region = region;
		this.country = country;
		this.postalCode = postalCode;
	}

	public AddressDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", street=" + street + ", region=" + region + ", country=" + country + ", postalCode=" + postalCode + "]";
	}

}
