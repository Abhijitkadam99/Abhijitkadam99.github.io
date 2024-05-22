package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.Model.CustomerRegistrationEntity;

public interface CustomerDtlsRepository extends JpaRepository<CustomerRegistrationEntity, Long> {


	public CustomerRegistrationEntity findByEmailAndPassword(String email, String password);

}
