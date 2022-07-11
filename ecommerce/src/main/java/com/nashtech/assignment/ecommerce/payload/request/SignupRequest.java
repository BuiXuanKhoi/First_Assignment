package com.nashtech.assignment.ecommerce.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

}
