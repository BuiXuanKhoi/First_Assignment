package com.nashtech.assignment.ecommerce.DTO.request;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateDTO {
	
	@NotBlank(message = "email cannot blank")
	private String userEmail;
	
	@Min(value = 8, message = "Password at least has 8 characters")
	private String userPassword;
	
	private String userName;

	
	
	@JsonProperty("email")
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@JsonProperty("password")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@JsonProperty("name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
	
	
	
	
	

}
