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
public class VehicleDetailsEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String vehicleRegisterNumber;
	private String vehicleTypes;
	//private String noOfVehicles;
	private String serviceTypes;
	private String serviceCharges;
	private String mobileNumber;
	private String avaliableSlots;
	private String status="Pending";
//	public void setRecid(Long recid) {
		// TODO Auto-generated method stub
		
	}

//}
