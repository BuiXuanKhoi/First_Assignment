package com.nashtech.assignment.ecommerce.payload.request;

import javax.validation.constraints.NotBlank;

public class RegisterAdmin {
	
	@NotBlank
	private int userId;
	
	private String adminGender;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdminGender() {
		return adminGender;
	}

	public void setAdminGender(String adminGender) {
		this.adminGender = adminGender;
	}

	public RegisterAdmin(@NotBlank int userId, String adminGender) {
		this.userId = userId;
		this.adminGender = adminGender;
	}
	
	
	

}
