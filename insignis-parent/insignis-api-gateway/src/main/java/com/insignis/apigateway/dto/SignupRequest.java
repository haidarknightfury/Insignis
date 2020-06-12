package com.insignis.apigateway.dto;

import java.util.HashSet;
import java.util.Set;

public class SignupRequest extends LoginRequest {

	private static final long serialVersionUID = 424154756394916982L;
	private String email;
	private Set<String> roles = new HashSet<String>();

	public SignupRequest(String username, String password, String email, Set<String> roles) {
		super(username, password);
		this.email = email;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRoles() {
		return roles;
	}

}
