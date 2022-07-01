package com.nashtech.assignment.ecommerce.payload.request;




import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterCustomer {
	
	@NotBlank
	private String customerAddres;
	
	@Size(min = 10, message = "Phone number has to have at least 10 number")
	private long customerPhoneNumber;
	
	private Date customerDateOfBirth;
	
	@NotBlank
	private int userId;
	
	
	
	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getCustomerAddres() {
		return customerAddres;
	}



	public void setCustomerAddres(String customerAddres) {
		this.customerAddres = customerAddres;
	}



	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}



	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}



	public Date getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}



	public void setCustomerDateOfBirth(Date customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}



	public RegisterCustomer(@NotBlank String customerAddres,
			@Size(min = 10, message = "Phone number has to have at least 10 number") long customerPhoneNumber,
			Date customerDateOfBirth, @NotBlank int userId) {
		this.customerAddres = customerAddres;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerDateOfBirth = customerDateOfBirth;
		this.userId = userId;
	}



	



	
	
	
	
	
	

}
