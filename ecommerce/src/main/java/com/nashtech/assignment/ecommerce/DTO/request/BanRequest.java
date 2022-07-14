package com.nashtech.assignment.ecommerce.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BanRequest {
	
	@JsonProperty("name")
	private String userName;
	
	@JsonProperty("reason")
	private String banReason;

}
