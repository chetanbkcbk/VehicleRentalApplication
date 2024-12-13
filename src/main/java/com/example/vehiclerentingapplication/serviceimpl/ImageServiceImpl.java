package com.example.vehiclerentingapplication.serviceimpl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.ImageNotFoundException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	private final UserRepository userRepository;
	
	private final ImageRepository imageRepository;
	
	public ImageServiceImpl(UserRepository userRepository,ImageRepository imageRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
	}


	@Override
	public void addUser_ProfilePicture(int userId, MultipartFile multipartFile) {
		Optional<User> optional = userRepository.findById(userId);
	
		if(optional.isPresent())
		{
			Image image = getImage(multipartFile);//invoking a method
				image=imageRepository.save(image);
				
				User user=optional.get();
				user.setProfilePicture(image);
				userRepository.save(user);
		}
		else
		{
			//throw exception 
			throw new UserNotFoundByIdException("no such userid");
		}
	}
	
	
	private Image getImage(MultipartFile multipartFile) {
		
		Image image=new Image();
		
		try {
			byte[] imageBytes = multipartFile.getBytes();
			image.setContentType(multipartFile.getContentType());
			image.setImageBytes(imageBytes);
			
		}
		catch(IOException e) {
			//throw custom exception
			throw new FailedToUploadImageException("image NOT uploaded");
		}
		return image;	
	}


	@Override
	public Image findImageById(int imageId) {

		Optional<Image> optional = imageRepository.findById(imageId);
		if(optional.isPresent())
		{
			 Image image = optional.get();
			 return image;
			
		}
		else
		{
			throw new ImageNotFoundException("Image with such an id not found");
			
		}	
		
	}

	
	

}
