package com.nashtech.assignment.ecommerce.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetail {
	
	private String recipient;
	private String message;
	private String subject;
	private String attachment;
	
	
	public EmailDetail(String recipient, String message, String subject) {
		this.recipient = recipient;
		this.message = message;
		this.subject = subject;
	}
	
	

}
