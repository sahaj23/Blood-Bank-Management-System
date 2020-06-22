package com.cognizant.training.bloodBank.repository;

import com.cognizant.training.bloodBank.model.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BloodBankRepository extends JpaRepository<BloodBank, Long>{
	
	@Query(value = "SELECT * FROM blood_bank WHERE email = :email and password= :password", nativeQuery = true)
	BloodBank bloodBankLogin(String email,String password);
}
