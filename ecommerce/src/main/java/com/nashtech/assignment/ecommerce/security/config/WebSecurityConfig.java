package com.nashtech.assignment.ecommerce.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthEntryPoint;
import com.nashtech.assignment.ecommerce.security.jwt.JwtAuthTokenFilter;
import com.nashtech.assignment.ecommerce.security.jwt.JwtUtils;
import com.nashtech.assignment.ecommerce.security.serviceImpl.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private final UserDetailServiceImpl userDetailServiceImpl;
	
	private final JwtAuthEntryPoint unauthorizedHandler;
	
	private final JwtUtils jwtUtils;
	
    public WebSecurityConfig (UserDetailServiceImpl userDetailServiceImpl, JwtAuthEntryPoint unauthorizedHandler, JwtUtils jwtUtils) {
        this.userDetailServiceImpl = userDetailServiceImpl;
        this.unauthorizedHandler = unauthorizedHandler;
        this.jwtUtils = jwtUtils;
    }
    
    @Bean
    public JwtAuthTokenFilter authenticationJwtTokenFilter() {
    	return new JwtAuthTokenFilter(jwtUtils, userDetailServiceImpl);
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailServiceImpl).passwordEncoder(passwordEncode());
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManagerBean();
    }
    
    
    @Bean
    public PasswordEncoder passwordEncode() {
    	return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable()
    		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
    		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    		.authorizeRequests()
    			.antMatchers("/feedbacks/**","/api/auth/**","/api/users/vertify").permitAll()
    			.antMatchers(HttpMethod.GET, "/api/products/**").permitAll()
    			.antMatchers(HttpMethod.PUT, "/api/users/status/**").permitAll()
    			.anyRequest().authenticated();
    	
    	http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    
   
	

}
