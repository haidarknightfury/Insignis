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
@JsonPropertyOrder({ "small", "okay", "large" })
public class Sizing implements Serializable {

	@JsonProperty("small")
	private Integer small;
	@JsonProperty("okay")
	private Integer okay;
	@JsonProperty("large")
	private Integer large;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = 7301612446881101910L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Sizing() {
	}

	/**
	 *
	 * @param small
	 * @param okay
	 * @param large
	 */
	public Sizing(Integer small, Integer okay, Integer large) {
		super();
		this.small = small;
		this.okay = okay;
		this.large = large;
	}

	@JsonProperty("small")
	public Integer getSmall() {
		return small;
	}

	@JsonProperty("small")
	public void setSmall(Integer small) {
		this.small = small;
	}

	@JsonProperty("okay")
	public Integer getOkay() {
		return okay;
	}

	@JsonProperty("okay")
	public void setOkay(Integer okay) {
		this.okay = okay;
	}

	@JsonProperty("large")
	public Integer getLarge() {
		return large;
	}

	@JsonProperty("large")
	public void setLarge(Integer large) {
		this.large = large;
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
		return new ToStringBuilder(this).append("small", small).append("okay", okay).append("large", large).append("additionalProperties", additionalProperties).toString();
	}

}
