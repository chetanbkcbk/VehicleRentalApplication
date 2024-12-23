package com.example.vehiclerentingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentingapplication.entity.DropLocation;


public interface DropRepository extends JpaRepository<DropLocation, Integer>{

}
