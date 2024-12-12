package com.example.vehiclerentingapplication.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	private final ImageRepository imageRepository;
	
	public UserServiceImpl(UserRepository userRepository,ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
	}

	

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	
}
