package com.example.vehiclerentingapplication.userserviceimpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.userrepository.UserRepository;
import com.example.vehiclerentingapplication.userservice.UserService;
import com.example.vehiclerentingapplication.utility.ResponseBuilder;
import com.example.vehiclerentingapplication.utility.ResponseStructure;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> register(User user) {

		User registereduser = userRepository.save(user);
		
		ResponseBuilder rb=new ResponseBuilder();
		
		return 	rb.sendResponse(HttpStatus.CREATED,"User Registered Successfully" ,registereduser);

	}

}
