package com.automobiles.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
 
@Configuration

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    // In this example we do not use Security.
    // Override this method with empty code
    // to disable the default Spring Boot security.
	
	@Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { }
   
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/").permitAll();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }



}
