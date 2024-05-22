package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.Model.CustomerContactDetailsEntity;

public interface CustomerContactDetailsRepository extends JpaRepository<CustomerContactDetailsEntity, Long>{

}
