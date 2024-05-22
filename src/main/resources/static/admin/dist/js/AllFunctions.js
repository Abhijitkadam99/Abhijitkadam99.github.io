

  
function getServiceCharges(value){
	
	alert("inside function charges")
	$.ajax({
		
		type:'ajax',
		method:'GET',
		url: "/getCharges",
		data: {vehicleType: value},
		
		success: function(data){
			document.getElementById("chargs").value=data.vehicleType;
		
			
		},
		
		
		error: function(){
			
		}
	});
}


