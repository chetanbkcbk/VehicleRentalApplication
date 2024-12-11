package com.example.vehiclerentingapplication.usercontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.userservice.UserService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;

@RestController
public class UserController {
	
	private final UserService userService ;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> register(@RequestBody User user)
	{
		return	userService.register(user);
	}
	

}
