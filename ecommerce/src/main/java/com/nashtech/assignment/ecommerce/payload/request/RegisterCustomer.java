package com.nashtech.assignment.ecommerce.payload.request;




import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCustomer {
	
	@NotBlank
	private String customerAddres;
	
	@Size(min = 10, message = "Phone number has to have at least 10 number")
	private long customerPhoneNumber;
	
	private Date customerDateOfBirth;
	
	@NotBlank
	private int userId;
	


}
