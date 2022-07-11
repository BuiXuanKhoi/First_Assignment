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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customers {


	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private int customerId;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@NonNull
	private Users users;
	

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
