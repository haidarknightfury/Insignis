package com.insignis.shared.dto;

import java.io.Serializable;
import java.util.List;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = -4128327098017403233L;
	private String id;
	private String name;
	private String username;
	private String password;
	private AddressDTO address;
	private List<ContactDTO> contacts;

	public ClientDTO(String id, String name, String username, String password, AddressDTO address, List<ContactDTO> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contacts = contacts;
	}

	public ClientDTO() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
