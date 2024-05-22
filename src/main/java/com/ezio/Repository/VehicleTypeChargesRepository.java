package com.ezio.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezio.Model.VehicleTypeChargesEntity;

public interface VehicleTypeChargesRepository extends JpaRepository<VehicleTypeChargesEntity, Long> {

	
	
//	@Query(nativeQuery = true, value= "SELECT full_charges FROM vehicle_service_db.vehicle_type_charges_entity where vehicle_type='car' and regular_charges='5000' ")
//	String getVehicleWiseCharge(VehicleTypeChargesEntity vehicletypecharges);


	VehicleTypeChargesEntity findByVehicleType(String vehicleType);



	
	
	
	
	
	
	
	
	
	/*
	 * @Query(nativeQuery = true,
	 * value="select service_charges from vehicle_service_db.service_types_entity where service_types='Full Service' "
	 * )
	 * 
	 * String getAllServiceCharges(String serviceCharges);
	 */
	
	
}
