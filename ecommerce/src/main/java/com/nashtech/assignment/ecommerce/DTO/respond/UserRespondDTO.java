package com.nashtech.assignment.ecommerce.DTO.respond;

import java.sql.Date;

public class UserRespondDTO {
	
	private int userID;	
	
	private String userName;
	
	private String userEmail;
	
	private String userPassword;
	
	private Date userCreateDay;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getUserCreateDay() {
		return userCreateDay;
	}

	public void setUserCreateDay(Date userCreateDay) {
		this.userCreateDay = userCreateDay;
	}
	
	

}
