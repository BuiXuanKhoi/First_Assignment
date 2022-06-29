package com.nashtech.assignment.ecommerce.DTO.respond;

import java.sql.Date;

public class UserRespondDTO {
	
	
	private String userName;
	
	private String userEmail;
	
	private Date userCreateDay;


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Date getUserCreateDay() {
		return userCreateDay;
	}

	public void setUserCreateDay(Date userCreateDay) {
		this.userCreateDay = userCreateDay;
	}
	
	

}
