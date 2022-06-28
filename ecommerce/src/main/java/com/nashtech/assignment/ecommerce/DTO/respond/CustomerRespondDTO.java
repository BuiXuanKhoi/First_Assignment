package com.nashtech.assignment.ecommerce.DTO.respond;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespondDTO {
	
	
	@JsonProperty("id")
	private int customerId;
	
	@JsonProperty("DateOfBirth")
	private Date customerDateOfBirth;
	
	
	@JsonProperty("Phone Number")
	private String customerPhoneNumber;
	
	private int userId;

}
