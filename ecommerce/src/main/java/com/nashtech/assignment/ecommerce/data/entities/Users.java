package com.nashtech.assignment.ecommerce.data.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_email")
	@NonNull
	private String userEmail;
	
	@Column(name = "user_name")
	@NonNull
	private String userName;
	
	@Column(name = "user_password")
	@NonNull
	private String userPassword;
	
	@Column(name = "user_create_day")
	private Date userCreateDay;
	
	@Column(name = "user_update_day")
	private Date userUpDateDay; 
	
	@Column(name = "status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "catogery_user_id")
	@JsonIgnore
	private Roles roles;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Banned banned;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL )
	private Customers customers;
	
	@OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
	private Admin admin;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProductFeedback> productFeedbacks;

	@JsonIgnore
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Orders> listOrders;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems> cartItems;
	
	public int getCatogeryUserId() {
		return this.getRoles().getRoleId();
	}

	public Users(@NonNull String userEmail, @NonNull String userName, @NonNull String userPassword) {
		this.userEmail = userEmail;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	



}
