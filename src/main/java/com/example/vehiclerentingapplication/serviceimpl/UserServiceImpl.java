package com.example.vehiclerentingapplication.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.enums.UserRole;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.mapper.UserMapper;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.requestdto.UserRequest;
import com.example.vehiclerentingapplication.responsedto.UserResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final ImageRepository imageRepository;

	private final UserMapper userMapper;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthUtil authUtil;

	public UserServiceImpl(UserRepository userRepository, ImageRepository imageRepository, UserMapper userMapper,PasswordEncoder passwordEncoder,AuthUtil authUtil) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
		this.userMapper = userMapper;
		this.passwordEncoder=passwordEncoder;
		this.authUtil=authUtil;
	}

	@Override
	public UserResponse register(UserRequest userrequest,UserRole userrole) {
		User user = userMapper.mapToUser(userrequest, new User());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		user.setRole(userrole);
		
		user = userRepository.save(user);

		return userMapper.mapToUserResponse(user);
	}

	
	
	@Override
	public UserResponse findUserById() {

//		Optional<User> optional = userRepository.findById(userId);
//		if (optional.isPresent()) {
//			User user = optional.get();
		
			User user = authUtil.getCurrentUser();
		
			UserResponse userresponse = userMapper.mapToUserResponse(user);

			Image profilePicture = user.getProfilePicture();
			
			if (profilePicture != null) {
				String profilePictureUrl = "/images/" + profilePicture.getImageId();
				
// The imageId is used to construct the URL. This ID uniquely identifies the image in your database.	            
//The URL is constructed as "/images/" + profilePicture.getImageId(), which points to the endpoint that serves the image	            

				userresponse.setProfilePictureLink(profilePictureUrl);
			}
			return userresponse;

	} 
//			else {
//			throw new UserNotFoundByIdException("no such userId");
//		}

	

	@Override
	public UserResponse updateUserById(UserRequest userRequest) {
			
//		Optional<User> optional =userRepository.findById(userId);
//		if (optional.isPresent()) {
//			
		User user = authUtil.getCurrentUser();
			
			 user = userMapper.mapToUser(userRequest, user);
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			user=userRepository.save(user);
			UserResponse userresponse = userMapper.mapToUserResponse(user);
		return userresponse;
	
//		else
//		{
//			throw new UserNotFoundByIdException("no such userId");
//			
//		}

}
}
