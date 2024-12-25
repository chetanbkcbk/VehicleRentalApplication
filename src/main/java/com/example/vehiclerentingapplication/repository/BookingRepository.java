package com.example.vehiclerentingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentingapplication.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
