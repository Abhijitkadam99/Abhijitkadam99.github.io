package com.ezio.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class VehicleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/*private Long id;
	private String name;
	private String vehicleRegisterNumber;
	private String vehicleTypes;
	private String noOfVehicles;
	private String serviceTypes;
	private String serviceCharges;
	private String avaliableSlots;*/
	
	private Long id;
	private String vehicleName;
	private String noOfVehicle;
	private String vehicleCharge;
	private String vehicleAddress;
	private String vehicleServiceType;	
	private String vehicleServiceNumber;
	private String vehicleServiceDate;
	private String vehicleUpcomingServiceDate;
	
}
