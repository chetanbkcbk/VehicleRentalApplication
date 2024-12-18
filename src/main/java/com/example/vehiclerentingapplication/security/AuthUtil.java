package com.example.vehiclerentingapplication.security;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.repository.UserRepository;

@Component 
public class AuthUtil {

	private final UserRepository userRepository;

	public AuthUtil(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public Authentication getAuthentication() {
		return	SecurityContextHolder.getContext().getAuthentication();
		
	}
	
	public String getCurrentUsername() {
		return	getAuthentication().getName(); //returns username
		
	}
	
	public User getCurrentUser() {
		Optional<User> userOptional = userRepository.findByEmail(getCurrentUsername());
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("No such User found"));
    }
		
		
	
	
}
