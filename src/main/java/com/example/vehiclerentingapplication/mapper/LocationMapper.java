package com.example.vehiclerentingapplication.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.requestdto.LocationRequest;
import com.example.vehiclerentingapplication.responsedto.LocationResponse;
import com.example.vehiclerentingapplication.responsedto.VehicleListingResponse;

@Component
public class LocationMapper {

	
	public Location mapToLocation(LocationRequest locationRequest,Location location)
	{
		location.setAddressLine(locationRequest.getAddressLine());
		location.setAddressLineOptional(locationRequest.getAddressLineOptional());
		location.setArea(locationRequest.getArea());
		location.setCity(locationRequest.getCity());
		location.setState(locationRequest.getState());
		location.setCountry(locationRequest.getCountry());
		location.setPincode(locationRequest.getPincode());
		location.setPhoneNumber(locationRequest.getPhoneNumber());
		
		return location;
	}
	
	
	public LocationResponse mapToLocationResponse(Location location)
	{
		LocationResponse locationResponse=new LocationResponse();
		
		locationResponse.setLocationId(location.getLocationId());
		locationResponse.setAddressLine(location.getAddressLine());
		locationResponse.setAddressLineOptional(location.getAddressLineOptional());
		locationResponse.setArea(location.getArea());
		locationResponse.setCity(location.getCity());
		locationResponse.setState(location.getState());
		locationResponse.setCountry(location.getCountry());
		locationResponse.setPincode(location.getPincode());
		locationResponse.setPhoneNumber(location.getPhoneNumber());
		
		return locationResponse;
	}
	
	public List<LocationResponse> mapToLocationResponses(List<Location> locations)
	{
		 return locations.stream()
                 .map(this::mapToLocationResponse)
                 .collect(Collectors.toList());
	}
	
}