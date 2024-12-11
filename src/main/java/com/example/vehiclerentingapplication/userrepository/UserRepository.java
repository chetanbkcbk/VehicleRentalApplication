package com.example.vehiclerentingapplication.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vehiclerentingapplication.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
