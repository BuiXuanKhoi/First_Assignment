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
	
	
	@JsonProperty("id")
	private int customerId;
	
	@JsonProperty("DateOfBirth")
	private Date customerDateOfBirth;
	
	
	@JsonProperty("Phone Number")
	private String customerPhoneNumber;
	
	private Users userId;

	
	
	//-------------------------------------------------Getter & Setter------------------------------------
	
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


	// Expose only user id
	@JsonProperty("User ID")
	public int getUserId() {
		return userId.getUserId();
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
	
	

}
