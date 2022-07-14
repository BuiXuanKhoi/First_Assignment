package com.nashtech.assignment.ecommerce.DTO.respond;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nashtech.assignment.ecommerce.data.entities.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRespondDTO {
	
	@JsonProperty("name")
	private String userName;
	
	@JsonProperty("email")
	private String userEmail;
	
	@JsonProperty("created at")
	private Date userCreateDay;
	
	@JsonProperty("role")
	private String Role;
	
}
