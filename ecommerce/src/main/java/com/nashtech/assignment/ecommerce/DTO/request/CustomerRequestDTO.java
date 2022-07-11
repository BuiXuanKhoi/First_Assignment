package com.nashtech.assignment.ecommerce.DTO.request;


import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequestDTO {
	
	@NotEmpty(message = "Please enter your date of birth")
	@JsonProperty("date of birth")
	private Date customerDateOfBirthDate;
	
	@NotEmpty(message = "This field cannot be empty")
	@Size(min = 9, max = 12, message = "Phone number is between 9 and 12 numbers")
	@JsonProperty("phone number")
	private int customerPhoneNumber;
	
	@NotEmpty(message = "This field cannot be empty")
	@JsonProperty("address")
	private String customerAddress;
	


}
