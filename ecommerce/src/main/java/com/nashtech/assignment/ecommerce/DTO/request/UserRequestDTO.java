package com.nashtech.assignment.ecommerce.DTO.request;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.nashtech.assignment.ecommerce.data.entities.Roles;

public class UserRequestDTO {
	

	EntityManager entityManager;
	
	@NotBlank(message = "Please enter your email")
	@Email(message = "Invalid Email Address")
	private String userEmail;
	
	@Min(value = 8, message = "Password at least has 8 characters")
	private String userPassword;
	
	@NotBlank(message = "Name cannot be null")
	private String userName;
	
	private Roles roles;
	
	private int userId;
	
	//-------------------------------------------------------Getter & Setter-----------------------------------------------


	public Roles getRoles() {
		return roles;
	}

	public void setRoles(String roleName) {
		Query roleIDQuery = entityManager.createQuery("SELECT r FROM roles r where r.catogery_user_role = :roleName");
		Roles roles = (Roles) roleIDQuery.getSingleResult();
		roles.setRoleName(roleName);
		this.roles = roles;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
