package com.ezio.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class DashBoardJsonResponse {
	
	
	
	/*
	 * private Long id; private String status;
	 */
	  
	 
		  // private Long id;
		   private Integer newOrder; 
		   private Integer orderInProcess; 
		   private Integer orderComplete;
		   private Integer cancleOrder; 
		   private Integer findAllOrder;
		 
}
