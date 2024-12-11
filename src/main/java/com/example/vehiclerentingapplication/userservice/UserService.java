package com.example.vehiclerentingapplication.userservice;

import org.springframework.http.ResponseEntity;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.utility.ResponseStructure;

public interface UserService {

	ResponseEntity<ResponseStructure<User>> register(User user);

}
