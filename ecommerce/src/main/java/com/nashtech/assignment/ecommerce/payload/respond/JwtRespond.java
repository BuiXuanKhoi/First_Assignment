package com.nashtech.assignment.ecommerce.payload.respond;

import java.util.List;

public class JwtRespond {
	
    private String token;
    private String type = "Bearer";
    private int id;
    private String username;
    private String email;
    private String roles;
    
    
    public String getTokenType() {
    	return type;
    }
    
    public void setTokenType(String tokenType) {
    	this.type = tokenType;
    }
    

	
	
	public String getAccessToken() {
		return token;
	}
	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public JwtRespond(String token, int id, String username, String email, String roles) {
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

    
    
    

	
	
    
    
    

}
