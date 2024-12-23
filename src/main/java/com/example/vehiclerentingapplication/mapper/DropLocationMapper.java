package com.example.vehiclerentingapplication.mapper;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.DropLocation;
import com.example.vehiclerentingapplication.requestdto.DropRequest;
import com.example.vehiclerentingapplication.responsedto.DropResponse;
 

@Component
public class DropLocationMapper {

	public DropLocation mapToDrop(DropRequest request, DropLocation drop) {
		
		drop.setDate(request.getDate());
		drop.setTime(request.getTime());
		
		return drop;
		}


	public DropResponse mapToDropResponse( DropLocation drop) {
		
		DropResponse dropResponse=new DropResponse();
		
		dropResponse.setPickupId(drop.getDropId());
		dropResponse.setDate(drop.getDate());
		dropResponse.setTime(drop.getTime());
		
		return dropResponse;
		}
}
