package com.example.vehiclerentingapplication.mapper;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.DropLocation;
import com.example.vehiclerentingapplication.entity.Location;
import com.example.vehiclerentingapplication.requestdto.BookingRequest;
import com.example.vehiclerentingapplication.requestdto.DropRequest;
import com.example.vehiclerentingapplication.responsedto.DropResponse;
 

@Component
public class DropLocationMapper {

	private final LocationMapper locationMapper;
	
	public DropLocationMapper(LocationMapper locationMapper) {
		super();
		this.locationMapper = locationMapper;
	}


	public DropLocation mapToDrop( DropLocation dropLocation,BookingRequest request,Location dropLocationPlace) {
		
	  //dropLocation.setDate(request.getPickUpDate());
	
		dropLocation.setTime(LocalTime.of(23, 59, 0));
		dropLocation.setLocation(dropLocationPlace);
		
		return dropLocation;
		}


	public DropResponse mapToDropResponse( DropLocation drop,Location dropLocation) {
		
		DropResponse dropResponse=new DropResponse();
		
		dropResponse.setDropId(drop.getDropId());
		dropResponse.setDate(drop.getDate());
		dropResponse.setTime(drop.getTime());
		dropResponse.setLocation(locationMapper.mapToLocationResponse(dropLocation));
		
		return dropResponse;
		}
}
