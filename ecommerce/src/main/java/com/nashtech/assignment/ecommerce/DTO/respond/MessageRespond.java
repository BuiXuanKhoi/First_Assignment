package com.nashtech.assignment.ecommerce.DTO.respond;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageRespond {
	
	private int statusCode;
	private String message;

}
