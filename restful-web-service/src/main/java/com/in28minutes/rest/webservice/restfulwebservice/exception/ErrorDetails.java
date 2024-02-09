package com.in28minutes.rest.webservice.restfulwebservice.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	//error page custom
	
	private LocalDateTime timestamp;
	private String message;
	private String detils;
	
	
	public ErrorDetails(LocalDateTime timestamp, String message, String detils) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detils = detils;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetils() {
		return detils;
	}

	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + "]";
	}
	

}
