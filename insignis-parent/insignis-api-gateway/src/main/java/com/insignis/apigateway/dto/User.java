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
@JsonPropertyOrder({ "fname", "uid", "did", "aid", "lname", "email", "billing", "address" })
public class User implements Serializable {

	@JsonProperty("fname")
	private String fname;
	@JsonProperty("uid")
	private String uid;
	@JsonProperty("did")
	private String did;
	@JsonProperty("aid")
	private String aid;
	@JsonProperty("lname")
	private String lname;
	@JsonProperty("email")
	private String email;
	@JsonProperty("billing")
	private List<Billing> billing = null;
	@JsonProperty("address")
	private List<Address> address = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	private final static long serialVersionUID = -7384476937858140200L;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public User() {
	}

	/**
	 *
	 * @param fname
	 * @param uid
	 * @param lname
	 * @param address
	 * @param aid
	 * @param did
	 * @param email
	 * @param billing
	 */
	public User(String fname, String uid, String did, String aid, String lname, String email, List<Billing> billing, List<Address> address) {
		super();
		this.fname = fname;
		this.uid = uid;
		this.did = did;
		this.aid = aid;
		this.lname = lname;
		this.email = email;
		this.billing = billing;
		this.address = address;
	}

	@JsonProperty("fname")
	public String getFname() {
		return fname;
	}

	@JsonProperty("fname")
	public void setFname(String fname) {
		this.fname = fname;
	}

	@JsonProperty("uid")
	public String getUid() {
		return uid;
	}

	@JsonProperty("uid")
	public void setUid(String uid) {
		this.uid = uid;
	}

	@JsonProperty("did")
	public String getDid() {
		return did;
	}

	@JsonProperty("did")
	public void setDid(String did) {
		this.did = did;
	}

	@JsonProperty("aid")
	public String getAid() {
		return aid;
	}

	@JsonProperty("aid")
	public void setAid(String aid) {
		this.aid = aid;
	}

	@JsonProperty("lname")
	public String getLname() {
		return lname;
	}

	@JsonProperty("lname")
	public void setLname(String lname) {
		this.lname = lname;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("billing")
	public List<Billing> getBilling() {
		return billing;
	}

	@JsonProperty("billing")
	public void setBilling(List<Billing> billing) {
		this.billing = billing;
	}

	@JsonProperty("address")
	public List<Address> getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(List<Address> address) {
		this.address = address;
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
		return new ToStringBuilder(this).append("fname", fname).append("uid", uid).append("did", did).append("aid", aid).append("lname", lname).append("email", email).append("billing", billing)
				.append("address", address).append("additionalProperties", additionalProperties).toString();
	}

}