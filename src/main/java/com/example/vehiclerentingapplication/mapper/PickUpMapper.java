package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.PickUp;
import com.example.vehiclerentingapplication.requestdto.PickUpRequest;
import com.example.vehiclerentingapplication.responsedto.PickUpResponse;

@Component
public class PickUpMapper {

	
public PickUp mapToPickUp(PickUpRequest request, PickUp pickUp) {
		
	pickUp.setDate(request.getDate());
	pickUp.setTime(request.getTime());
	
	return pickUp;
	}


public PickUpResponse mapToPickUpResponse( PickUp pickUp) {
	
	PickUpResponse pickUpResponse=new PickUpResponse();
	
	pickUpResponse.setPickupId(pickUp.getPickupId());
	pickUpResponse.setDate(pickUp.getDate());
	pickUpResponse.setTime(pickUp.getTime());
	
	return pickUpResponse;
	}
}