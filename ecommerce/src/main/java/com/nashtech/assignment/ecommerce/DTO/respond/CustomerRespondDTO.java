package com.nashtech.assignment.ecommerce.DTO.respond;

import java.security.KeyStore.PrivateKeyEntry;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	

}
