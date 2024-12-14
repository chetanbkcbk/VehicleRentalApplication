package com.example.vehiclerentingapplication.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.enums.UserRole;
import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;

public interface UserService {

	UserResponse register(UserRequest userrequest,UserRole userrole);

	UserResponse findUserById(int userId);

	UserResponse updateUserById(UserRequest userRequest, int userId);


}
