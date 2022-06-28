package com.nashtech.assignment.ecommerce.DTO.request;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

public class CustomerUpdateDTO {
	
	@NotEmpty(message = "Please enter your date of birth")
	private Date customerDateOfBirthDate;
	
	@NotEmpty(message = "This field cannot be empty")
	private int customerPhoneNumber;
	
	@NotEmpty(message = "This field cannot be empty")
	private String customerAddress;

	public Date getCustomerDateOfBirthDate() {
		return customerDateOfBirthDate;
	}

	public void setCustomerDateOfBirthDate(Date customerDateOfBirthDate) {
		this.customerDateOfBirthDate = customerDateOfBirthDate;
	}

	public int getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(int customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	

}
