package com.nashtech.assignment.ecommerce.DTO.respond;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespondDTO {
	

	
	@JsonProperty("DateOfBirth")
	private Date customerDateOfBirth;
	
	
	@JsonProperty("phone number")
	private String customerPhoneNumber;
	
	@JsonProperty("address")
	private String customerAddress;
	
	

}
