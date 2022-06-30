package com.nashtech.assignment.ecommerce.DTO.respond;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Roles;

public class UserRespondDTO {
	
	
	private String userName;
	
	private String userEmail;
	
	private Date userCreateDay;
	
	private Roles roles;


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

	@JsonIgnore
	public Roles getRoles() {
		return roles;
	}
	
	@JsonProperty("Role")
	public String getRoleId() {
		return roles.getRoleName();
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	
	
	

}
