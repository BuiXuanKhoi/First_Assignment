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

@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customers {
	
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;
	
	@OneToOne
	@JoinColumn(name = "user_id")
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
	
	
	
	//---------------------------
	
	
	
	
	
	@Column(name = "customer_name")
	private String customer_name;
	
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

	

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public Date getCustomer_date_of_birth() {
		return customer_date_of_birth;
	}

	public void setCustomer_date_of_birth(Date customer_date_of_birth) {
		this.customer_date_of_birth = customer_date_of_birth;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	public long getCustomer_phone_number() {
		return customer_phone_number;
	}

	public void setCustomer_phone_number(long customer_phone_number) {
		this.customer_phone_number = customer_phone_number;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	@Column(name = "customer_date_of_birth")
	private Date customer_date_of_birth;
	
	@Column(name = "customer_address")
	private  String customer_address;
	
	@Column(name = "customer_phone_number")
	private long customer_phone_number;
	
	@Column(name = "customer_email")
	private String customer_email;
	
	@Column(name = "customer_password")
	private String customer_password;
	
	
	

}
