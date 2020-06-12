package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "address_line_1", "address_line_2", "city", "last_name", "phone_number", "zipcode", "country", "first_name", "state" })
public class Address implements Serializable {

	@JsonProperty("address_line_1")
	private String addressLine1;
	@JsonProperty("address_line_2")
	private String addressLine2;
	@JsonProperty("city")
	private String city;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("phone_number")
	private Integer phoneNumber;
	@JsonProperty("zipcode")
	private Integer zipcode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("state")
	private String state;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -1778407747476259524L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Address() {
	}

	/**
	 *
	 * @param zipcode
	 * @param lastName
	 * @param country
	 * @param firstName
	 * @param phoneNumber
	 * @param city
	 * @param addressLine1
	 * @param addressLine2
	 * @param state
	 */
	public Address(String addressLine1, String addressLine2, String city, String lastName, Integer phoneNumber, Integer zipcode, String country, String firstName, String state) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.zipcode = zipcode;
		this.country = country;
		this.firstName = firstName;
		this.state = state;
	}

	@JsonProperty("address_line_1")
	public String getAddressLine1() {
		return addressLine1;
	}

	@JsonProperty("address_line_1")
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@JsonProperty("address_line_2")
	public String getAddressLine2() {
		return addressLine2;
	}

	@JsonProperty("address_line_2")
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("phone_number")
	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	@JsonProperty("phone_number")
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@JsonProperty("zipcode")
	public Integer getZipcode() {
		return zipcode;
	}

	@JsonProperty("zipcode")
	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
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
		return new ToStringBuilder(this).append("addressLine1", addressLine1).append("addressLine2", addressLine2).append("city", city).append("lastName", lastName).append("phoneNumber", phoneNumber)
				.append("zipcode", zipcode).append("country", country).append("firstName", firstName).append("state", state).append("additionalProperties", additionalProperties).toString();
	}

}