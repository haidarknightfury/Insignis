package com.insignis.apigateway.dto;

import java.io.Serializable;

public class MessageResponse implements Serializable {

	private static final long serialVersionUID = 2449178257369083787L;
	private String message;

	public MessageResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}