package com.ezio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ezio.Model.VehicleDetailsEntity;

public interface VehicleDetailsRepository extends JpaRepository<VehicleDetailsEntity ,Long> {

	@Modifying
	@Transactional
	@Query("update VehicleDetailsEntity set status =:status where id=:id")
	 void findStatusById(Long id, String status);

		/*
		 * @Query("select count(status) from VehicleDetailsEntity where status =:status"
		 * ) Long coundStatus(String status);
		 */

	     
	   @Query(nativeQuery = true, value="select count(id) from vehicle_pointe_db.vehicle_details_entity where status ='Pending';")
	   Integer gettingNewOrderCount();

	   
	   @Query(nativeQuery = true, value="select count(id) from vehicle_pointe_db.vehicle_details_entity where status ='In-Process';")
	   Integer gettingOrderInProcessCount();

	   @Query(nativeQuery = true, value="select count(id) from vehicle_pointe_db.vehicle_details_entity where status ='Completed';")
	   Integer gettingOrderCompletedCount();

	   @Query(nativeQuery = true, value="select count(id) from vehicle_pointe_db.vehicle_details_entity where status ='Cancle';")
	   Integer getCancelingOrders();

       @Query(nativeQuery = true, value="SELECT COUNT(id) FROM vehicle_pointe_db.vehicle_details_entity WHERE status IN ('Cancle', 'Completed', 'In-Process', 'Pending');") 
	   Integer gettingAllOrders();

	  


	  
	   
	//VehicleDetailsEntity findStatusById(Long id);

	//VehicleDetailsEntity findStatusById();

}
