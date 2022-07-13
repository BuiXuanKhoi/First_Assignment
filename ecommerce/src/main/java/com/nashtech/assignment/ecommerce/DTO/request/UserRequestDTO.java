package com.nashtech.assignment.ecommerce.DTO.request;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.nashtech.assignment.ecommerce.data.entities.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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


}
