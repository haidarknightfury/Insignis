package com.insignis.shared.dto;

import java.io.Serializable;
import java.util.List;

public class SupplierDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String email;
	private AddressDTO address;
	private List<ContactDTO> contacts;

	public SupplierDTO(String id, String name, String email, AddressDTO address, List<ContactDTO> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;
		this.setEmail(email);
	}

	public SupplierDTO() {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SupplierDTO [id=" + id + ", name=" + name + ", address=" + address + ", contacts=" + contacts + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
