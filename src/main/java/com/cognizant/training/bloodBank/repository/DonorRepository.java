package com.cognizant.training.bloodBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.training.bloodBank.model.BloodBank;
import com.cognizant.training.bloodBank.model.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long>{

	@Query(value = "SELECT * FROM donor WHERE email = :email and password= :password", nativeQuery = true)
	BloodBank donorLogin(String email,String password);
}
