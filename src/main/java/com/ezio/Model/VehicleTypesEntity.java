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
public class VehicleTypesEntity {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String VehicleType;
	
	

}
