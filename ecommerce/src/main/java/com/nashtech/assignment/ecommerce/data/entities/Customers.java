package com.nashtech.assignment.ecommerce.data.entities;

import java.sql.Date;
import java.util.List;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.data.annotation.Reference;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customers {
	
	
	
	
	public Customers() {
	}





	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	@NonNull
	private Users users;
	
	
	//----------------------------
	
	
	
	@OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Orders orders;
	
	@JsonIgnore
	@OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Cart cart;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItems> cartItems;
	
	@OneToOne(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProductFeedback productFeedback;
	

	
	
	
	//---------------------------
	
	
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	


	public Date getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(Date customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(Long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}





	@Column(name = "customer_date_of_birth")
	private Date customerDateOfBirth;
	
	@Column(name = "customer_address")
	private  String customerAddress;
	
	@Column(name = "customer_phone_numer")
	private Long customerPhoneNumber;





	public Customers(@NonNull Users users, Date customerDateOfBirth, String customerAddress, Long customerPhoneNumber) {
		this.users = users;
		this.customerDateOfBirth = customerDateOfBirth;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
	}

	
	
	
	

}
