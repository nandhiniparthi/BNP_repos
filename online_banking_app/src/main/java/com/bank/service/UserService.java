package com.bank.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.bank.model.User;
import com.bank.web.dto.UserRegistrationDto;

public interface UserService  extends UserDetailsService{

	User findByUsername(String username);
	User save(UserRegistrationDto registrationDto);
}
