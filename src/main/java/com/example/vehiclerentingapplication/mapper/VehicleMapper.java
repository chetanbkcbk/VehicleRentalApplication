package com.example.vehiclerentingapplication.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.vehiclerentingapplication.entity.User;
import com.example.vehiclerentingapplication.entity.Vehicle;
import com.example.vehiclerentingapplication.requestdto.VehicleRequest;
import com.example.vehiclerentingapplication.responsedto.VehicleResponse;

@Component
public class VehicleMapper {

public Vehicle mapToVehicle(VehicleRequest request, Vehicle vehicle) {
		
		vehicle.setBrand(request.getBrand());
		vehicle.setType(request.getType());
		vehicle.setModel(request.getModel());
		vehicle.setFuelType(request.getFuelType());
	//	vehicle.setImages(request.getFiles());
		
		return vehicle;	
		
	}
	
	
	public VehicleResponse mapToVehicleResponse(Vehicle vehicle) {
		
		VehicleResponse vehicleResponse = new VehicleResponse();
		vehicleResponse.setVehicleId(vehicle.getVehicleId());
		vehicleResponse.setBrand(vehicle.getBrand());
		vehicleResponse.setType(vehicle.getType());
		vehicleResponse.setModel(vehicle.getModel());
		vehicleResponse.setFuelType(vehicle.getFuelType());
	//	vehicleResponse.setImages(vehicle.getImages());
	
		
		return vehicleResponse;
		
	}
	
	public List<VehicleResponse> mapToVehicleResponse(List<Vehicle> vehicles) {
        return vehicles.stream()
                       .map(this::mapToVehicleResponse)
                       .collect(Collectors.toList());
    }
}
