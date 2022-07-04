package com.nashtech.assignment.ecommerce.security.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nashtech.assignment.ecommerce.data.entities.Users;
import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthEntryPoint;

public class UserDetailImpl implements UserDetails {
	
	private int id;
	
	private String userName;
	
	private String userEmail;
	
	private String userPassword;
	
	private  Collection<? extends GrantedAuthority> authorities;
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailImpl.class);

	
	
	
	

	public UserDetailImpl(int id, String userName, String userEmail, String userPassword,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.authorities = authorities;
	}

	
	public static UserDetailImpl build(Users users) {
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		authorities.add(new SimpleGrantedAuthority(users.getRoles().getRoleName()));
		log.error("Authority: {}  ", authorities);
		
		return new UserDetailImpl(users.getUserId(), 
				users.getUserName(), 
			    users.getUserEmail(), 
				users.getUserPassword(), 
				authorities);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return userPassword;
	}

	@Override
	public String getUsername() {
		return userName;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        UserDetailImpl user = (UserDetailImpl) obj;
        return Objects.equals(id, user.id);
	}
	
	

}
