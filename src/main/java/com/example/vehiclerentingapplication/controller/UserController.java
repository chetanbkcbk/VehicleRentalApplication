package com.example.vehiclerentingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.service.UserService;
import com.example.vehiclerentingapplication.utility.ResponseStructure;
import com.example.vehiclerentingapplication.utility.RestResponseBuilder;
import com.example.vehiclerentingapplication.utility.SimpleResponseStructure;

@RestController
public class UserController {
	
	private final UserService userService ;
	private final RestResponseBuilder responseBuilder;

	public UserController(UserService userService, RestResponseBuilder responseBuilder) {
		super();
		this.userService = userService;
		this.responseBuilder = responseBuilder;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<User>> register(@RequestBody User user)
	{
		user = userService.register(user);
		return responseBuilder.success(HttpStatus.CREATED, "User Registration successful", user);
	}
	
	@PostMapping("/users/profile-picture")
	public ResponseEntity<SimpleResponseStructure> addUser_ProfilePicture(@RequestParam int userId,MultipartFile multipartFile)
	{
		userService.addUser_ProfilePicture(userId,multipartFile);
		return responseBuilder.success(HttpStatus.OK, "User profile picture updated");
	}

}
