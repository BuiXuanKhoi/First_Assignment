package com.nashtech.assignment.ecommerce.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	
	@NotBlank
	private String userName;
	
	@NotBlank
	private String userPassword;	

}
