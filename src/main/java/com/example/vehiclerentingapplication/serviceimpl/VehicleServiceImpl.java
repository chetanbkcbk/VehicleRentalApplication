package com.example.vehiclerentingapplication.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.exception.FailedToUploadImageException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.mapper.VehicleMapper;
import com.example.vehiclerentingapplication.repository.ImageRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.requestdto.VehicleRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleResponse;
import com.example.vehiclerentingapplication.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	private final VehicleMapper vehicleMapper;
	private final VehicleRepository vehicleRepository;
	private final ImageRepository imageRepository;
	
	public VehicleServiceImpl(VehicleMapper vehicleMapper,VehicleRepository vehicleRepository,ImageRepository imageRepository) {
		super();
		this.vehicleMapper = vehicleMapper;
		this.vehicleRepository=vehicleRepository;
		this.imageRepository=imageRepository;
	}

	@Override
	public VehicleResponse addVehicle(VehicleRequest vehicleRequest) {
		
		Vehicle vehicle=vehicleMapper.mapToVehicle(vehicleRequest, new Vehicle());
		
		
	    vehicle=vehicleRepository.save(vehicle); // Save the vehicle to the repository
	
	    VehicleResponse vehicleResponse=vehicleMapper.mapToVehicleResponse(vehicle);
	
	    return vehicleResponse;
	}

	@Override
	public List<VehicleResponse> findAllVehicles() {

		List<Vehicle> vehicles = vehicleRepository.findAll();
	   List< VehicleResponse> vehicleResponse=vehicleMapper.mapToVehicleResponse(vehicles);
	   
	   

		
		return vehicleResponse;
	}

	@Override
	public VehicleResponse updateVehicleById(VehicleRequest vehicleRequest,int vehicleId) {

		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		
		if(optional.isPresent())
		{
			Vehicle vehicle=vehicleMapper.mapToVehicle(vehicleRequest, optional.get());
			vehicle=vehicleRepository.save(vehicle);
			
		return vehicleMapper.mapToVehicleResponse(vehicle);
		}
		else
		{	
		
		throw new VehicleNotFoundException("Vehicle with such id Not found");
		}
	}
	

	

}
