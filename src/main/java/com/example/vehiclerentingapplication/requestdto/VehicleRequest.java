package com.example.vehiclerentingapplication.requestdto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.vehiclerentingapplication.entity.Image;
import com.example.vehiclerentingapplication.enums.FuelType;
import com.example.vehiclerentingapplication.enums.VehicleType;

public class VehicleRequest {

	private String brand;
	private VehicleType type;
	private String model;
	private FuelType fuelType;
//	private List<MultipartFile> files;
	
	
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public VehicleType getType() {
		return type;
	}
	public void setType(VehicleType type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
//	public List<MultipartFile> getFiles() {
//		return files;
//	}
//	public void setFiles(List<MultipartFile> files) {
//		this.files = files;
//	}
//	
	
	
}
