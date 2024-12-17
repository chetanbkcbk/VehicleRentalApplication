package com.example.vehiclerentingapplication.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	
	private final UserRepository userRepository;
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= userRepository.findByEmail(username) // Map the User to UserDetailsImpl
                .orElseThrow(() -> new UsernameNotFoundException("User  not found with email: " + username));
    return new UserDetailsImpl(user);
	}
	

}
