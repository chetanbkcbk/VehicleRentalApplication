package com.example.vehiclerentingapplication.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.enums.UserRole;
import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;
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
	
	@PostMapping("/customer/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerCustomer(@RequestBody UserRequest userrequest)
	{
		UserResponse userresponse = userService.register(userrequest,UserRole.CUSTOMER);
		return responseBuilder.success(HttpStatus.CREATED, "User Registration successful", userresponse);
	}
	
	
	@PostMapping("/renting-partner/register")
	public ResponseEntity<ResponseStructure<UserResponse>> registerRentingPartner(@RequestBody UserRequest userrequest)
	{
		UserResponse userresponse = userService.register(userrequest,UserRole.RENTING_PARTNER);
		return responseBuilder.success(HttpStatus.CREATED, "User Registration successful", userresponse);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable int userId)
	{
		UserResponse userresponse = userService.findUserById(userId);
		return responseBuilder.success(HttpStatus.FOUND, "User found ",userresponse);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@RequestBody UserRequest userRequest,@PathVariable int userId){
		
		UserResponse userResponse=userService.updateUserById(userRequest,userId);
		return responseBuilder.success(HttpStatus.OK, "User Updated ",userResponse);
	}

	
	
	
}
