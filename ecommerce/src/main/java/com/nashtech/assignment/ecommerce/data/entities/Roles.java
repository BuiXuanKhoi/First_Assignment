package com.nashtech.assignment.ecommerce.data.entities;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catogery_id")
	private Integer roleId;
	
	
	@Column(name = "catogery_user_role")
	@NotNull
	private String roleName;
	
	@Column(name = "catogery_user_id")
	@NotNull
	private int catogeryUserId;
	
	

	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Users> users = new ArrayList<Users>();
	

}
