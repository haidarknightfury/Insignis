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
@JsonPropertyOrder({ "card_number", "expiry_date" })
public class Billing implements Serializable {

	@JsonProperty("card_number")
	private String cardNumber;
	@JsonProperty("expiry_date")
	private String expiryDate;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 6970128707686428787L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Billing() {
	}

	/**
	 *
	 * @param expiryDate
	 * @param cardNumber
	 */
	public Billing(String cardNumber, String expiryDate) {
		super();
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
	}

	@JsonProperty("card_number")
	public String getCardNumber() {
		return cardNumber;
	}

	@JsonProperty("card_number")
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@JsonProperty("expiry_date")
	public String getExpiryDate() {
		return expiryDate;
	}

	@JsonProperty("expiry_date")
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
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
		return new ToStringBuilder(this).append("cardNumber", cardNumber).append("expiryDate", expiryDate).append("additionalProperties", additionalProperties).toString();
	}

}