package com.nashtech.assignment.ecommerce.data.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@NoArgsConstructor
public class Users {
	
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int userId;
	
	public Users(int userId, String userName, String userEmail, String userPassword, Date userCreateDate,
			Date userUpDate, Roles catogeryUserId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userCreateDay = userCreateDate;
		this.userUpDateDay = userUpDate;
		this.roles = catogeryUserId;
	}
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public Date getUserCreateDate() {
		return userCreateDay;
	}

	public void setUserCreateDate(Date userCreateDate) {
		this.userCreateDay = userCreateDate;
	}

	public Date getUserUpDate() {
		return userUpDateDay;
	}

	public void setUserUpDate(Date userUpDate) {
		this.userUpDateDay = userUpDate;
	}

	public Roles getCatogeryUserId() {
		return roles;
	}

	public void setCatogeryUserId(Roles catogeryUserId) {
		this.roles = catogeryUserId;
	}

	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_create_day")
	private Date userCreateDay;
	
	@Column(name = "user_update_day")
	private Date userUpDateDay; 
	
	@ManyToOne
	@JoinColumn(name = "catogery_user_id")
	private Roles roles;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL )
	private Customers customers;
	
	

}
