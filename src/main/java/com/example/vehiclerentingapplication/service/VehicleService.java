package com.example.vehiclerentingapplication.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.requestdto.VehicleRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleResponse;

public interface VehicleService {

	VehicleResponse addVehicle(VehicleRequest vehicleRequest);

	List<VehicleResponse> findAllVehicles();

	VehicleResponse updateVehicleById(VehicleRequest vehicleRequest, int vehicleId);


}
