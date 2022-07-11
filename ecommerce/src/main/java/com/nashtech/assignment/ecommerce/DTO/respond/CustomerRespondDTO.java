package com.nashtech.assignment.ecommerce.DTO.respond;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
public class CustomerRespondDTO {
	

	
	@JsonProperty("DateOfBirth")
	private Date customerDateOfBirth;
	
	
	@JsonProperty("Phone Number")
	private String customerPhoneNumber;
	
	@JsonProperty("Address")
	private String customerAddress;
	

	
	
	//-------------------------------------------------Getter & Setter------------------------------------
	


	public Date getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(Date customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	





	
	
	

}
