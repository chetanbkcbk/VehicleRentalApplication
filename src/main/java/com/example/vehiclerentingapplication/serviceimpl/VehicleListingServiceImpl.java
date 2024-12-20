package com.example.vehiclerentingapplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.NoSuchLocationException;
import com.example.vehiclerentingapplication.exception.NoVehicleListingException;
import com.example.vehiclerentingapplication.exception.VehicleNotFoundException;
import com.example.vehiclerentingapplication.mapper.VehicleListingMapper;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.repository.VehicleRepository;
import com.example.vehiclerentingapplication.requestdto.VehicleListingRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleListingResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.service.VehicleListingService;

@Service
public class VehicleListingServiceImpl implements VehicleListingService{

	private final VehicleListingRepository vehicleListingRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleListingMapper vehicleListingMapper;
	private final AuthUtil authUtil;
	private final LocationRepository locationRepository;
	
	






	public VehicleListingServiceImpl(VehicleListingRepository vehicleListingRepository,
			VehicleRepository vehicleRepository, VehicleListingMapper vehicleListingMapper, AuthUtil authUtil,
			LocationRepository locationRepository) {
		super();
		this.vehicleListingRepository = vehicleListingRepository;
		this.vehicleRepository = vehicleRepository;
		this.vehicleListingMapper = vehicleListingMapper;
		this.authUtil = authUtil;
		this.locationRepository = locationRepository;
	}




	@Override
	public VehicleListingResponse insertVehicleListing(int vehicleId, VehicleListingRequest vehicleListingRequest) {

		Optional<Vehicle> optionalvehicle = vehicleRepository.findById(vehicleId);

		Vehicle vehicle;
		if(optionalvehicle.isPresent())
		{
			 vehicle=optionalvehicle.get();
		}
		else {
		throw new VehicleNotFoundException("no vehicle with such vehicle id");
		}	
			User rentingPartner = authUtil.getCurrentUser();
			
			VehicleListing vehicleListing = vehicleListingMapper.mapToVehicleListing(vehicleListingRequest, new VehicleListing());
											vehicleListing.setVehicle(vehicle);
											vehicleListing.setRentingPartner(rentingPartner);
						   vehicleListing=vehicleListingRepository.save(vehicleListing);
	return vehicleListingMapper.mapToVehicleListingResponse(vehicleListing);
	}




	@Override
	public List<VehicleListingResponse> findAllVehicleListings(int vehicleId) {
				
			if(!vehicleRepository.existsById(vehicleId))
				throw new VehicleNotFoundException("Vehicle with such vehicle id not found");
		
			List<VehicleListing> vehicleListings = vehicleListingRepository.findByVehicle_VehicleId(vehicleId);
		
			return vehicleListingMapper.mapToVehicleListingResponse(vehicleListings);
	}




	@Override
	public void addLocationToVehicleListing(int locationId, int listingId) {

		Location location = locationRepository.findById(locationId).orElseThrow(()->new NoSuchLocationException("no such location id "));

		VehicleListing vehicleListing = vehicleListingRepository.findById(listingId).orElseThrow(()->new NoVehicleListingException("no such vehicleListing id"));
		
		vehicleListing.getPickupLocations().add(location);
		location.getVehicleListings().add(vehicleListing);
		
		vehicleListingRepository.save(vehicleListing);
        locationRepository.save(location); // This may not be necessary if the location is not modified

	}

	
	
}
