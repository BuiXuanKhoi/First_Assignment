package com.nashtech.assignment.ecommerce.DTO.respond;

import java.util.Map;

public class ErrorResponse {
	
	private int status;
	
	private String message;
	
	private Map<String, String> validateMessage;
	
	
	
	
	



	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, String> getValidateMessage() {
		return validateMessage;
	}

	public void setValidateMessage(Map<String, String> validateMessage) {
		this.validateMessage = validateMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}





	public ErrorResponse(int status, String message, Map<String, String> validateMessage) {
		this.status = status;
		this.message = message;
		this.validateMessage = validateMessage;
	}

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
