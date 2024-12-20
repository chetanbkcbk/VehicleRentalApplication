package com.example.vehiclerentingapplication.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.exception.NoVehicleListingException;
import com.example.vehiclerentingapplication.mapper.LocationMapper;
import com.example.vehiclerentingapplication.repository.LocationRepository;
import com.example.vehiclerentingapplication.repository.VehicleListingRepository;
import com.example.vehiclerentingapplication.requestdto.LocationRequest;
import com.example.vehiclerentingapplication.responsedto.LocationResponse;
import com.example.vehiclerentingapplication.security.AuthUtil;
import com.example.vehiclerentingapplication.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService{

	private final LocationRepository locationRepository;
	private final LocationMapper locationMapper;
	private final AuthUtil authUtil;
	private final VehicleListingRepository vehicleListingRepository;
	

	



	




	public LocationServiceImpl(LocationRepository locationRepository, LocationMapper locationMapper, AuthUtil authUtil,
			VehicleListingRepository vehicleListingRepository) {
		super();
		this.locationRepository = locationRepository;
		this.locationMapper = locationMapper;
		this.authUtil = authUtil;
		this.vehicleListingRepository = vehicleListingRepository;
	}


	@Override
	public LocationResponse addLocation(LocationRequest locationRequest) {

		Location location = locationMapper.mapToLocation(locationRequest, new Location());
						
		User rentingPartner = authUtil.getCurrentUser();
							location.setUser(rentingPartner);
		location=locationRepository.save(location);
		
		return locationMapper.mapToLocationResponse(location);
	}


	@Override
	public List<LocationResponse> findAllLocationsByListingId(int listingId) {

		 VehicleListing vehicleListing = vehicleListingRepository.findById(listingId).orElseThrow(()->new NoVehicleListingException("no such vehiclelisting id"));
		
		 List<Location> locations = vehicleListing.getPickupLocations();
		 
		return locationMapper.mapToLocationResponses(locations);
		 
	}

}
