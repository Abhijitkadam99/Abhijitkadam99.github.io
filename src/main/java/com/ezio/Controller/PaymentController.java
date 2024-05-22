package com.ezio.Controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.var;

@Controller
public class PaymentController {
	
	 // creating order for payment
    // @RequestMapping(value = "/create_order", method = RequestMethod.POST)   	          
	  // @ResponseBody
	   @PostMapping("/create_order")
		@ResponseBody
	   public String createOrder(@RequestBody Map<String, Object> data) throws Exception {
   	  
   	  
   	  int amt=Integer.parseInt(data.get("amount").toString());
 		
 		 var client=new RazorpayClient("rzp_test_KXPeMTkJLvdP4T", "K4SnydDMRzKYYP1zGpQsNjR2");
 		
 		JSONObject ob=new JSONObject();
 		ob.put("amount", amt*100);
 		ob.put("currency", "INR");
 		ob.put("receipt", "txn_235425");
 		
 		//creating new order
 		
 		Order order = client.orders.create(ob);
 		System.out.println(order);
 		
 		//if you want you can save this to your data..		
 		return order.toString();
	 
     }
	
	

}
