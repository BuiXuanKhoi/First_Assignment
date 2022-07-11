package com.nashtech.assignment.ecommerce.DTO.request;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.nashtech.assignment.ecommerce.data.entities.Roles;

public class UserRequestDTO {
	

	EntityManager entityManager;
	
	@NotBlank(message = "Email is required")
	@Min(value = 5, message = "Name should have at least 5 character")
	@Email(message = "Invalid Email Address")
	private String userEmail;
	
	@NotBlank(message = "Please enter password")
	@Min(value = 8, message = "Password at least has 8 characters")
	private String userPassword;
	
	@NotBlank(message = "Please enter user name")
	private String userName;
	
	

	
	//-------------------------------------------------------Getter & Setter-----------------------------------------------




	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	


}
