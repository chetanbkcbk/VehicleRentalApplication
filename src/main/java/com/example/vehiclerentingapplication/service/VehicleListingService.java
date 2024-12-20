package com.example.vehiclerentingapplication.service;

import java.util.List;

import com.example.vehiclerentingapplication.requestdto.VehicleListingRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleListingResponse;

public interface VehicleListingService {


	VehicleListingResponse insertVehicleListing(int vehicleId, VehicleListingRequest vehicleListingRequest);

	List<VehicleListingResponse> findAllVehicleListings(int vehicleId);

}
