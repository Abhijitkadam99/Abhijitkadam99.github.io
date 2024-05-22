package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezio.Model.VehicleEntity;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

}
