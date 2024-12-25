package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.requestdto.PickUpRequest;
import com.example.vehiclerentingapplication.responsedto.PickUpResponse;

@Component
public class PickUpMapper {

	private final LocationMapper locationMapper;
	
	
public PickUpMapper(LocationMapper locationMapper) {
		super();
		this.locationMapper = locationMapper;
	}


public PickUp mapToPickUp( PickUp pickUp,BookingRequest bookingRequest,Location pickUpLocation) {
		
	pickUp.setDate(bookingRequest.getPickUpDate());
	pickUp.setTime(bookingRequest.getPickUpTime());
	pickUp.setLocation(pickUpLocation);
	
	return pickUp;
	}


public PickUpResponse mapToPickUpResponse( PickUp pickUp,Location pickUpLocation) {
	
	PickUpResponse pickUpResponse=new PickUpResponse();
	
	pickUpResponse.setPickupId(pickUp.getPickupId());
	pickUpResponse.setDate(pickUp.getDate());
	pickUpResponse.setTime(pickUp.getTime());
	pickUpResponse.setLocation(locationMapper.mapToLocationResponse(pickUpLocation));
	
	return pickUpResponse;
	}
}