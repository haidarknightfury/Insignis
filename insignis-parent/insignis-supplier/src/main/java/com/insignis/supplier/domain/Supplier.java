package com.insignis.supplier.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.insignis.shared.domain.Address;
import com.insignis.shared.domain.Contact;

@Document(collection = "supplier")
public class Supplier implements Serializable {

	private static final long serialVersionUID = 8346056030239785989L;

	@Id
	private String id;

	@NotNull
	@Indexed
	private String name;
	private Address address;
	private String email;
	private List<Contact> contacts;

	public Supplier(String id, String name, String email, Address address, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;
		this.email = email;
	}

	public Supplier() {
		super();
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
