package com.nashtech.assignment.ecommerce.DTO.request;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertiRequest {
	
	@JsonProperty("name")
	private String userName;
	
	@JsonProperty("code")
	private String vertiCode;

}
