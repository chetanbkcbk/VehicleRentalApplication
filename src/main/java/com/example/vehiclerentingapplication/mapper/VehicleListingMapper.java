package com.example.vehiclerentingapplication.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.VehicleListing;
import com.example.vehiclerentingapplication.requestdto.VehicleListingRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleListingResponse;

@Component
public class VehicleListingMapper {

	public VehicleListing mapToVehicleListing(VehicleListingRequest request,VehicleListing vehicleListing)
	{
		vehicleListing.setPricePerDay(request.getPricePerDay());
		vehicleListing.setSeating(request.getSeating());
		vehicleListing.setVehicleNo(request.getVehicleNo());
		
		return vehicleListing;
	}
	
	public VehicleListingResponse mapToVehicleListingResponse(VehicleListing vehicleListing)
	{
		VehicleListingResponse vehicleListingResponse=new VehicleListingResponse();
		vehicleListingResponse.setListingId(vehicleListing.getListingId());
		vehicleListingResponse.setPricePerDay(vehicleListing.getPricePerDay());
		vehicleListingResponse.setSeating(vehicleListing.getSeating());
		vehicleListingResponse.setVehicleNo(vehicleListing.getVehicleNo());
		
		return vehicleListingResponse;
	}
	
	public List<VehicleListingResponse> mapToVehicleListingResponse(List<VehicleListing> vehicleListings)
	{
		 return vehicleListings.stream()
                 .map(this::mapToVehicleListingResponse)
                 .collect(Collectors.toList());
	}
}
