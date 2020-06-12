package com.insignis.apigateway.dto;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -6685677051542435806L;
	private String jwt;
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String jwt, String id, String username, String email, List<String> roles) {
		this.jwt = jwt;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}
