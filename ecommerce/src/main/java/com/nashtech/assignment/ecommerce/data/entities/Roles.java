package com.nashtech.assignment.ecommerce.data.entities;

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

import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catogery_id")
	private Integer roleId;
	
	
	
	@Column(name = "catogery_name")
	private String roleName;
	
	
	@OneToMany(mappedBy = "roles", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private List<Users> users = new ArrayList<Users>();

	public Roles(Integer roleID) 
	{
		super();
		this.roleId = roleID;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
