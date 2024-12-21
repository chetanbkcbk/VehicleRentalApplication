package com.example.vehiclerentingapplication.service;

import java.util.List;

import com.example.vehiclerentingapplication.requestdto.LocationRequest;
import com.example.vehiclerentingapplication.responsedto.LocationResponse;

public interface LocationService {

	LocationResponse addLocation(LocationRequest locationRequest);

	List<LocationResponse> findAllLocationsByListingId(int listingId);

}
