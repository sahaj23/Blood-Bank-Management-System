package com.cognizant.training.bloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.training.bloodBank.model.BloodDetails;

public interface BloodDetailsRepository extends JpaRepository<BloodDetails, Long>{

}
