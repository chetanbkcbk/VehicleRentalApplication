package com.example.vehiclerentingapplication.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;

public interface UserService {

	UserResponse register(UserRequest userrequest);

	UserResponse findUserById(int userId);


}
