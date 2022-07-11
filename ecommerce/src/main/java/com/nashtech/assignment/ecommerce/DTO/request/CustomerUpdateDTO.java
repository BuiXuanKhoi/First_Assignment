package com.nashtech.assignment.ecommerce.DTO.request;


import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDTO {
	
	@JsonProperty("id")
	private int customerId;
	
	@NotBlank(message = "Please enter your date of birth")
	@JsonProperty("date of birth")
	private Date customerDateOfBirthDate;
	
	@NotBlank(message = "This field cannot be empty")
	@JsonProperty("phone number")
	private int customerPhoneNumber;
	
	@NotBlank(message = "This field cannot be empty")
	@JsonProperty("address")
	private String customerAddress;

}
