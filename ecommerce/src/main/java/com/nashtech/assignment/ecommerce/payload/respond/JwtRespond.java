package com.nashtech.assignment.ecommerce.payload.respond;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtRespond {
	
    private String token;
    private String type = "Bearer";
    private int id;
    private String username;
    private String email;
    private String roles;
    
    
	public JwtRespond(String token, int id, String username, String email, String roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
    
    

    
    

}
