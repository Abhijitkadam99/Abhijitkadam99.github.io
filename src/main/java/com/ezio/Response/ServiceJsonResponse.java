package com.ezio.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServiceJsonResponse {

	
    private String vehicleType;
	private String charges;
	//private String ServiceType;
	
}
