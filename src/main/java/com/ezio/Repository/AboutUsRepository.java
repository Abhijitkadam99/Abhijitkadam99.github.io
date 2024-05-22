package com.ezio.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezio.Model.AboutUsEntity;

public interface AboutUsRepository extends JpaRepository<AboutUsEntity, Long> {

	
	
	
	/*
	 * @Query(nativeQuery= true,
	 * value=" select * from vehicle_pointe_db.about_us_entity limit 5")
	 * List<AboutUsEntity> getAll();
	 */

	
	@Query(nativeQuery= true, value=" select * from vehicle_pointe_db.about_us_entity limit 1")
	AboutUsEntity getAllAboutDetails();

	// @Query(nativeQuery= true, value=" select * from vehicle_pointe_db.about_us_entity limit 5;")
     //AboutUsEntity getAllAboutDetails();

	//AboutUsEntity getAboutUsData(Long id);

}
