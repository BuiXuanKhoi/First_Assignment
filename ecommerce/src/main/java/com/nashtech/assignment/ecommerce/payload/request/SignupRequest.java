package com.nashtech.assignment.ecommerce.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

	@NotBlank
	@Size(min = 3, max = 30, message = "Your user name has to have at lease 3 charater and max is 30 characters")
	private String userName;
	
	@NotBlank
	private String userEmail;
	
	private String role;
	
	
	@NotBlank
	@Size(min = 8, max = 20, message = "Your user name has to have at lease 8 charater and max is 20 characters")
	private String userPassword;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public SignupRequest(
			@NotBlank @Size(min = 3, max = 30, message = "Your user name has to have at lease 3 charater and max is 30 characters") String userName,
			@NotBlank String userEmail, String role,
			@NotBlank @Size(min = 8, max = 20, message = "Your user name has to have at lease 8 charater and max is 20 characters") String userPassword) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.role = role;
		this.userPassword = userPassword;
	}
	
	
	
	
	
}
