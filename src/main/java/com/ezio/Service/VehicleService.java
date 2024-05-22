package com.ezio.Service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezio.Model.AboutUsEntity;
import com.ezio.Model.AddTeam;
import com.ezio.Model.CustomerContactDetailsEntity;
import com.ezio.Model.CustomerRegistrationEntity;
import com.ezio.Model.VehicleDetailsEntity;
import com.ezio.Model.VehicleTypeChargesEntity;
import com.ezio.Model.VehicleTypesEntity;
import com.ezio.Repository.AboutUsRepository;
import com.ezio.Repository.AddTeamRepository;
import com.ezio.Repository.CustomerContactDetailsRepository;
import com.ezio.Repository.CustomerDtlsRepository;
import com.ezio.Repository.VehicleDetailsRepository;
import com.ezio.Repository.VehicleRepository;
import com.ezio.Repository.VehicleTypeChargesRepository;
import com.ezio.Repository.VehicleTypeRepository;

@Service
public class VehicleService {
	
	@Autowired
    VehicleRepository vehiclerepo;

	@Autowired
	CustomerDtlsRepository customerRepo;
	
	@Autowired
	VehicleTypeRepository vehicleTypeRepo;
	
	@Autowired
	VehicleTypeChargesRepository vehicleTypeChargesRepo;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepo;
	
	@Autowired
	CustomerContactDetailsRepository CusContactDtlsRepo;
	
	@Autowired
	AboutUsRepository aboutusrepo;
	
	@Autowired
	AddTeamRepository addteamrepo;
	

	

	public void saveCustomer(CustomerRegistrationEntity custreg) {
		customerRepo.save(custreg);
	}


/*	public void vehicleTypes(VehicleTypesEntity vh) {
		vehicleTypeRepo.
		
		
	}  */
	

	public CustomerRegistrationEntity getEmailPassword(String email, String password) {
	//	String status="Active";
		return customerRepo.findByEmailAndPassword(email,password);
		 
	}


	public void saveVehicleTypes(VehicleTypesEntity vehitypes) {
		
		vehicleTypeRepo.save(vehitypes);
		
	}


	public List<VehicleTypesEntity> getAllTableDetails() {
		
		return vehicleTypeRepo.findAll();
	}


	public void saveServiceTypes(VehicleTypeChargesEntity servicetypes) {
		
		vehicleTypeChargesRepo.save(servicetypes);
	}


	public List<VehicleTypeChargesEntity> getAllServiceTableDetails() {
		
		return vehicleTypeChargesRepo.findAll();
	}


	public void deleteById(Long id) {
		
		vehicleTypeRepo.deleteById(id);
	}


	public void deleteServiceById(Long id) {
		
		vehicleTypeChargesRepo.deleteById(id);
	}

	/*
	 * public String getAllServiceCharges(String serviceCharges) {
	 * 
	 * return serviceTypeRepo.getAllServiceCharges(serviceCharges) ; }
	 */


	     // imp for getting charges details
	/*
	 * public String gettingAllServiceCharges(String serviceCharges) { // TODO
	 * Auto-generated method stub return
	 * serviceTypeRepo.getAllServiceCharges(serviceCharges) ; }
	 */


	public void saveVehicleDetails(VehicleDetailsEntity vehicleDetails) {
		vehicleDetailsRepo.save(vehicleDetails);
		
	}


	public List<VehicleDetailsEntity> findAll1() {
		// TODO Auto-generated method stub
		return vehicleDetailsRepo.findAll();
	}


	

	public void deletevehicleDetailsById(Long id) {
		vehicleDetailsRepo.deleteById(id);
		
	}


	public void save(VehicleDetailsEntity vh1) {
		vehicleDetailsRepo.save(vh1);
		
	}


	public VehicleDetailsEntity findAllVehicleDetailsById(Long id) {
		
		return vehicleDetailsRepo.findById(id).get();
	}


	public VehicleTypeChargesEntity findAllServiceTypeDetailsById(Long id) {
		
		return vehicleTypeChargesRepo.findById(id).get() ;
	}


	public void save(VehicleTypeChargesEntity s1) {
		vehicleTypeChargesRepo.save(s1);
		
		
	}


	public VehicleTypesEntity findAllVehicleDetailById(Long id) {
		
		return vehicleTypeRepo.findById(id).get();
	}


	public void save(VehicleTypesEntity v1) {
		
		 vehicleTypeRepo.save(v1);
	}


	public void saveCustomerContact(CustomerContactDetailsEntity cusDtls) {
		
		CusContactDtlsRepo.save( cusDtls);
	}


	public List<CustomerContactDetailsEntity> findAll2() {
		// TODO Auto-generated method stub
		return CusContactDtlsRepo.findAll();
	}


	public void deleteCustomerContactDtlsById(Long id) {
		CusContactDtlsRepo.deleteById(id);
		
	}


	public void saveAboutUs(AboutUsEntity aboutus) {
		aboutusrepo.save(aboutus);
		
	}


	public List<AboutUsEntity> findAll3() {
		
		return aboutusrepo.findAll();
	}


	public void deleteAboutUsDtlsById(Long id) {
		
		aboutusrepo.deleteById(id);
	}


	public AboutUsEntity findAllAboutUsDtlsById(Long id) {
		
		return aboutusrepo.findById(id).get();
	}


	public void save(AboutUsEntity Ae1) {
		aboutusrepo.save(Ae1);
		
	}


	public List<VehicleTypesEntity> findVehicleList() {
		return vehicleTypeRepo.findAll();
	}


	public List<VehicleTypeChargesEntity> findAllVehicleList() {
		
		return vehicleTypeChargesRepo.findAll();
	}


	/*
	 * public String gettingAllServiceCharges(VehicleTypeChargesEntity
	 * vehicletypecharges) {
	 * 
	 * return vehicleTypeChargesRepo.getVehicleWiseCharge(vehicletypecharges); }
	 */

	
	/*
	 * public List<AboutUsEntity> getAll() {
	 * 
	 * return aboutusrepo.getAll(); }
	 */
	 



	// have to write query here 
		
	public AboutUsEntity getAboutDetails() {
	  
	  return aboutusrepo.getAllAboutDetails();
	  }


		/*
		 * public void findStatusById(Long id, String status) {
		 * 
		 * vehicleDetailsRepo.findStatusById(id,status); }
		 */


		
	     public void findStatusById(Long id, String status) {	  
         vehicleDetailsRepo.findStatusById(id,status);
		  
		  }


		public List<VehicleDetailsEntity> processData() {
			return vehicleDetailsRepo.findAll();
		}


		/*
		 * public Long coundComplateOrders(String status) { return
		 * vehicleDetailsRepo.coundStatus(status); }
		 */

		
		  public Integer getNewOrderCount() {
		  
		  return vehicleDetailsRepo.gettingNewOrderCount(); }


		public Integer getOrderInProcessCount() {
			
			return vehicleDetailsRepo.gettingOrderInProcessCount();
		}


		public Integer getOrderCompletedCount() {
			
			return vehicleDetailsRepo.gettingOrderCompletedCount();
		}


		public Integer getCancleOrders() {
			
			return vehicleDetailsRepo.getCancelingOrders();
		}


		public Integer getAllOrders() {
		
			return vehicleDetailsRepo.gettingAllOrders();
		}


		public VehicleTypeChargesEntity gettingAllServiceCharges(String vehicleType) {
			return vehicleTypeChargesRepo.findByVehicleType(vehicleType);
		}


		public List<AddTeam> findAll() {
			
			return addteamrepo.findAll();
		}


		public void saveAddTeam(AddTeam ateam) {
			
			addteamrepo.save(ateam);
		}


		


		
	

		/*
		 * public void updateStatusById(Long id) { vehicleDetailsRepo.findById(id);
		 * 
		 * }
		 */


	

	
	/*
	 * public List<AboutUsEntity> getAboutDetails() {
	 * 
	 * return aboutusrepo.findAll(); }
	 */

	/*
	 * public AboutUsEntity getAboutUsData(Long id) {
	 * 
	 * return aboutusrepo.getAboutUsData(id); }
	 */
	
	
   
 	
	// for image
	/*
	 * public AboutUsEntity getAboutUsData(Long id) {
	 * 
	 * return aboutusrepo.findById(id).get(); }
	 */





	
	
	
	

	

}
