package com.nashtech.assignment.ecommerce.DTO.request;

import java.sql.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class UserUpdateDTO {
	
	@NotBlank(message = "email cannot blank")
	private String email;
	
	@NotBlank(message = "password cannot null")
	@Min(value = 8, message = "Password at least has 8 characters")
	private String password;
	
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
