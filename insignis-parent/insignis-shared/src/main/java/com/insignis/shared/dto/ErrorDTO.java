package com.insignis.shared.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private String message;
	private String causedBy;

	public ErrorDTO(String message, String causedBy) {
		super();
		this.message = message;
		this.causedBy = causedBy;
	}

	public ErrorDTO() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCausedBy() {
		return causedBy;
	}

	public void setCausedBy(String causedBy) {
		this.causedBy = causedBy;
	}

}
