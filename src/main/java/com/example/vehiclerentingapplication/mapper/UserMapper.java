package com.example.vehiclerentingapplication.mapper;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;

@Component
public class UserMapper {
	
	
	public User mapToUser(UserRequest request, User user) {
		
		user.setUsername(request.getUsername());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setPhoneNumber(request.getPhoneNumber());
//		user.setRole(request.getRole());
		
		return user;	
		
	}
	
	
	public UserResponse mapToUserResponse(User user) {
		
		UserResponse userresponse = new UserResponse();
		
		userresponse.setUserId(user.getUserId());
		userresponse.setUsername(user.getUsername());
		userresponse.setEmail(user.getEmail());
		userresponse.setPhoneNumber(user.getPhoneNumber());
		userresponse.setRole(user.getRole());
//		userresponse.setRole(null);
		
		return userresponse;
		
		
	}
	

}
