package com.example.vehiclerentingapplication.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.ImageNotFoundException;
import com.example.vehiclerentingapplication.exception.UserNotFoundByIdException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.UserRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	private final UserRepository userRepository;
	
	private final ImageRepository imageRepository;
	
	private final VehicleRepository vehicleRepository;
	
	private final AuthUtil authUtil;	
	
	public ImageServiceImpl(UserRepository userRepository,ImageRepository imageRepository,VehicleRepository vehicleRepository,AuthUtil authUtil) {
		super();
		this.userRepository = userRepository;
		this.imageRepository=imageRepository;
		this.vehicleRepository=vehicleRepository;
		this.authUtil=authUtil;
	}


	@Override
	public void addUser_ProfilePicture( MultipartFile multipartFile) {
		
		User user = authUtil.getCurrentUser();

	        // Check if the user already has a profile picture
	        if (user.getProfilePicture() != null) {
	            // If a profile picture exists, delete it before adding the new one
	            
	        	Image existingProfilePicture = user.getProfilePicture();
	            this.uploadUserProfile(multipartFile, user);
	            imageRepository.delete(existingProfilePicture);
	        }
	        this.uploadUserProfile(multipartFile, user);//if profilepic not present it will add       
	    
	}
	
	private void uploadUserProfile(MultipartFile file,User user)
	{
		 Image image = imageRepository.save(this.getImage(file)); // Save the new image to the repository

	        // Update the user's profile picture reference
	        user.setProfilePicture(image);
	        userRepository.save(user); // Save the updated user
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


	@Override
	public void addVehicleImages(int vehicleId, List<MultipartFile> multipartfiles) {
		
		Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
	    
	    if (optionalVehicle.isPresent()) {
	        Vehicle vehicle = optionalVehicle.get(); // Get the vehicle object
	        List<Image> images = new ArrayList<>();

	        for (MultipartFile file : multipartfiles) {
	            Image image = getImage(file); // Upload each image
	            images.add(image); // Add the image to the list
	        }

	        vehicle.getImages().addAll(images); // Add the new images to the existing list of images
	        vehicleRepository.save(vehicle); // Save the updated vehicle
	    } else {
	        throw new VehicleNotFoundException("No vehicle found with ID: " + vehicleId); // Handle vehicle not found
	    }
	}

	
	

}
