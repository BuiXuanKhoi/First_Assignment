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
public class RegisterAdmin {
	
	@NotBlank
	private int userId;
	
	private String adminGender;

}
