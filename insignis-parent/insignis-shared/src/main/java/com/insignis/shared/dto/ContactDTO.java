package com.insignis.shared.dto;

import java.io.Serializable;

import com.insignis.shared.enums.ContactType;

public class ContactDTO implements Serializable {

	private String id;
	private String mobileNumber;
	private String contactType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public ContactDTO(String id, String mobileNumber, String contactType) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.contactType = contactType;
	}

	public ContactDTO() {
	}

	@Override
	public String toString() {
		return "ContactDTO [id=" + id + ", mobileNumber=" + mobileNumber + ", contactType=" + contactType + "]";
	}

	
}
