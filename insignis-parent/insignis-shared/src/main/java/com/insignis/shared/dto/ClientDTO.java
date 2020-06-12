package com.insignis.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = -4128327098017403233L;
	private String id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private AddressDTO address;
	private List<ContactDTO> contacts;

	public ClientDTO() {
	}

	public ClientDTO(String userId, String firstName, String lastName, String email, AddressDTO address, List<ContactDTO> contacts) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.contacts = contacts;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public List<ContactDTO> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactDTO> contacts) {
		this.contacts = contacts;
	}

}
