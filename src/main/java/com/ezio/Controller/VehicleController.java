 package com.ezio.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezio.Model.AboutUsEntity;
import com.ezio.Model.AddTeam;
import com.ezio.Model.CustomerContactDetailsEntity;
import com.ezio.Model.CustomerRegistrationEntity;
import com.ezio.Model.VehicleDetailsEntity;
import com.ezio.Model.VehicleTypeChargesEntity;
import com.ezio.Model.VehicleTypesEntity;
import com.ezio.Response.DashBoardJsonResponse;
import com.ezio.Service.VehicleService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.var;



@Controller
public class VehicleController {

	@Autowired
	VehicleService vehicleservice;

	/*
	 * @Autowired AddServicde adService;
	 */
	/*
	 * @Autowired About
	 */

	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads";
	
	@RequestMapping("/payment")
	public String PaymentPage() {
		return "webpages/payment";
	}


	@RequestMapping("/comman")
	public String homePage() {
		return "comman/layout";
	}

	@RequestMapping("/dashboard")
	public String dashboardPage() {
		return "admin/dashboard";

	}

	@RequestMapping("/web")
	public String webpage() {
		return "comman/webindex";
	}

	@RequestMapping("/admin_login")
	public String login() {

		return "login.html";
	}

	@RequestMapping("/register")
	public String register() {

		return "register.html";
	}

	@RequestMapping("/vhtypes")
	public String vehicleTypes() {
		return "admin/vehicletypes";
	}

	@RequestMapping("/Vehicle_charges")
	public String serviceTypes() {
		return "admin/VehicleChargesdetails";
	}

	@RequestMapping("/new_bookings")
	public String newBookings() {
		return "admin/newbookings";

	}

	@RequestMapping("/Cus_contact_Dtls")
	public String cusContactDtls() {
		return "admin/contactus";

	}

	@RequestMapping("/appoinment_dashboard")
	public String appoinmentDashboard() {
		return "admin/appoinmentdashboard";

	}

	@RequestMapping("/new_order")
	public String newOrder() {
		return "admin/neworder";

	}

	@RequestMapping("/order_Inprocess")
	public String orderInprocess() {
		return "admin/OrderInProcess";

	}

	@RequestMapping("/Cancle_Order")
	public String orderCancle() {
		return "admin/CancleOrder";

	}

	@RequestMapping("/Order_Completed")
	public String orderComplete() {
		return "admin/OrderCompleted";

	}
	
	@RequestMapping("/Find_All_Order")
	public String fildAllOrder() {
		return "admin/FindAllOrder";

	}

	// method for saving backend data in frontend page

	@RequestMapping("/about_us")
	public String aboutUsDtls() {

		/*
		 * AboutUsEntity about = vehicleservice.getAboutDetails();
		 * model.addAttribute("about", about);
		 */
		return "admin/aboutus";

	}

	/*
	 * @RequestMapping("/about_us") public String aboutUsDtls() { return
	 * "admin/aboutus";
	 * 
	 * }
	 */
	@RequestMapping("/contact")
	public String contactUs() {
		return "webpages/contact.html";

	}

	@RequestMapping("/about")
	public String aboutUs(Model model) {

		AboutUsEntity about = vehicleservice.getAboutDetails();
		System.err.println("about   " + about);
		model.addAttribute("aboutus", about);

		return "webpages/about";

	}

	@RequestMapping("/services")
	public String ourServices() {
		return "webpages/services";

	}

	@RequestMapping("/web_login")
	public String webLogin() {

		return "webpages/login";

	}
	
	@RequestMapping("/full_service")
	public String fullService() {

		return "webpages/fullservice";

	}


	@RequestMapping("/regular_service")
	public String regularService() {

		return "webpages/regularservice";

	}
	

	@RequestMapping("/check_our_team")
	public String checkOurTeam() {
		return "webpages/team";
	}
	
	
	@RequestMapping("/add_team")
	public String addTeam() {
		return "admin/addteam";
	}
	

	@RequestMapping("/vehicleCharges")
	public String vehicleCharges() {
		return "admin/vehiclecharges";

	}

	// save method for about us details

	// @RequestMapping(value ="/About_Dtls", method = RequestMethod.POST)

	// @ResponseBody() public void saveAboutUs(AboutUsEntity aboutus) {
	// System.out.println("about us details");

	// vehicleservice.saveAboutUs(aboutus);
	// }

	// end

	// for getting about us details data(table) in admin table
	@RequestMapping(value = "/getAboutUsDtls", method = RequestMethod.GET)
	@ResponseBody
	     List<AboutUsEntity> getAboutUsDetails() {

		System.out.println("getting About Us details");
		List<AboutUsEntity> list2 = vehicleservice.findAll3();
		return list2;

	}
	// end
	
	// for getting add team details data(table) in admin table
		@RequestMapping(value = "/get_Add_Team", method = RequestMethod.GET)
		@ResponseBody
	     List<AddTeam> getAddTeam(){
	    	 System.out.println("get add team dtls");
	    	 List<AddTeam> addteam = vehicleservice.findAll();
			return addteam;
	    	 
	     }
	
	
	
	

	/*
	 * // method for showing about us data on html page
	 * 
	 * @RequestMapping(value = "/getAll", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public String getAll(Model model) {
	 * 
	 * List<AboutUsEntity> aboutus = vehicleservice.getAll();
	 * model.addAttribute("aboutus", aboutus);
	 * 
	 * AboutUsEntity about = vehicleservice.getAboutDetails();
	 * System.err.println("about   " + about); model.addAttribute("aboutus", about);
	 * return "about"; }
	 */

	// delete methos for AboutUs
	@GetMapping("/deleteAboutUsDtls")
	@ResponseBody
	public void deleteAboutUsDtlsById(Long id, Model model) {

		vehicleservice.deleteAboutUsDtlsById(id);
	}

	// for editing data in About us
	@RequestMapping(value = "/editAboutUsDtlsById", method = RequestMethod.GET)
	@ResponseBody
	public AboutUsEntity editAboutUs(Long id) {
		return vehicleservice.findAllAboutUsDtlsById(id);

	}

	// save method for customer contact details and send mail
	@RequestMapping(value = "/saveContactDtls", method = RequestMethod.POST)
	@ResponseBody()
	public String saveCustomerContact(CustomerContactDetailsEntity cusDtls) throws IOException, ScriptException {

		String customerName = cusDtls.getCustomerName();
		String customerMail = cusDtls.getCustomerEmail();
		System.err.println("call: ");

		final String username = "abkadam099@gmail.com";
		final String password = "xyrqalixpfojpgir";

		Properties props = new Properties();
		System.err.println("props" + props);
		props.put("mail.smtp.user", username);
		System.err.println("username:  " + username);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");// 465
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session sessions = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(sessions);

			message.setFrom(new InternetAddress(customerMail));

			String subject = "Thank you for connecting ";
			String msg = "welcome to Autocare..! Thank you for connecting we will working on your query ...we will contact you <br> Name: "
					+ customerName + "<br>Thank";

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerMail));
			System.out.println("mail " + customerMail);
			message.setSubject(subject);

			// message.setSubject("New IB Order Received #"+ orderid);
			/* System.out.println("user_id "+user_id); */
			/*
			 * String
			 * link="<a href='http://35.200.142.134/DentaLinks/admin/verificationcheck?user_id="
			 * +user_id+"'>Click Here For Verification</a>";
			 * System.out.println("link "+link);
			 */
			message.setContent("<br>Hello sir/mam...<br> " + msg + "", "text/html");

			Transport.send(message);
			/* System.out.println("user_id"+user_id); */
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

		vehicleservice.saveCustomerContact(cusDtls);
		return "Saved";

	}

	// end

	/*
	 * @RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	 * 
	 * @ResponseBody() public VehicleDetailsEntity
	 * saveVehicleDetails(VehicleDetailsEntity vehicleDetails, HttpSession session)
	 * throws IOException, ScriptException { System.out.println("vehicle details");
	 * 
	 * vehicleservice.saveVehicleDetails(vehicleDetails); SendMail mail1 = new
	 * SendMail();
	 * 
	 * vehicleservice.saveVehicleDetails(vehicleDetails); String subject =
	 * "Appoinment Confirmation For Vehicle Service"; String msg =
	 * "  Hello greattings!.."; //msg.concat(""); int result =
	 * mail1.sendMail(subject, vehicleDetails.getEmail(), msg);
	 * System.err.println(" check email response " + result); return vehicleDetails;
	 * }
	 */

	// for getting customer contact us details data(table) in admin table
	@RequestMapping(value = "/getCustomerContDtls", method = RequestMethod.GET)
	@ResponseBody
	List<CustomerContactDetailsEntity> getCustomerContactDetails() {

		// System.out.println("getting details");
		List<CustomerContactDetailsEntity> list2 = vehicleservice.findAll2();
		return list2;

	}
	// end

	// delete methos for newbooking
	@GetMapping("/deleteCustomerContactDtls")
	@ResponseBody
	public void deleteCustomerContactDtlsById(Long id, Model model) {

		vehicleservice.deleteCustomerContactDtlsById(id);
	}

	// for save **vehicle details**

	/*
	 * @RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	 * 
	 * @ResponseBody() public void saveVehicleDetails(VehicleDetailsEntity
	 * vehicleDetails) { System.out.println("vehicle details");
	 * 
	 * vehicleservice.saveVehicleDetails(vehicleDetails); }
	 */

	// save method for save vehicle details and send mail
	@RequestMapping(value = "/saveDetails", method = RequestMethod.POST)
	@ResponseBody()
	public String saveVehicleDetails(VehicleDetailsEntity vehicleDetails) throws IOException, ScriptException {

		System.err.println("call: ");

		String customerName = vehicleDetails.getName();
		String customerMail = vehicleDetails.getEmail();
		System.err.println("customerMail:  " + customerMail);
		String vehicleNo = vehicleDetails.getVehicleRegisterNumber();
		String serviceType = vehicleDetails.getServiceTypes();
		String serviceCharge = vehicleDetails.getServiceCharges();
		String serviceDate = vehicleDetails.getAvaliableSlots();

//			public int sendMail(String subject, String mail,String clmessage) {

//			 private static final int BUFFER_SIZE = 4096;

		System.err.println("call: ");

		final String username = "abkadam099@gmail.com";
		final String password = "xyrqalixpfojpgir";

		Properties props = new Properties();
		System.err.println("props" + props);
		props.put("mail.smtp.user", username);
		System.err.println("username:  " + username);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");// 465
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session sessions = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(sessions);

			message.setFrom(new InternetAddress(customerMail));

			String subject = "Appoinment Confirmation For Vehicle Service";
			String msg = "welcome to Autocare..! Thank you for booking... <br> Name: " + customerName
					+ "<br> Vehicle No: " + vehicleNo + "<br>Service Type: " + serviceType + "<br>Service Charge: "
					+ serviceCharge + "<br>Service date: " + serviceDate;

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(customerMail));
			System.out.println("mail " + customerMail);
			message.setSubject(subject);

			message.setContent("<br>Hello sir/mam...<br> " + msg + "", "text/html");

			Transport.send(message);

			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

		vehicleservice.saveVehicleDetails(vehicleDetails);
		return "Saved";

	}

	// method for save customer
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	@ResponseBody()
	public void saveCustomer(CustomerRegistrationEntity cus) {

		System.out.println("hello");

		vehicleservice.saveCustomer(cus);
	}

	// methods for vehicleType start //
	@RequestMapping(value = "/saveVehicleTypes", method = RequestMethod.POST)
	@ResponseBody
	public void saveVehicleTypes(VehicleTypesEntity vehitypes) {
		System.out.println("111111111");
		vehicleservice.saveVehicleTypes(vehitypes);
	}

	@RequestMapping(value = "/fetchTableDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleTypesEntity> fetchTableDetails() {
		return vehicleservice.getAllTableDetails();
	}
	// methods for vehicleType ends //

	// methods for serviceType start //
	@RequestMapping(value = "/saveServiceType", method = RequestMethod.POST)
	@ResponseBody
	public void saveServiceType(VehicleTypeChargesEntity servicetypes) {
		System.out.println("2222222");
		vehicleservice.saveServiceTypes(servicetypes);
	}

	@RequestMapping(value = "/getServiceTableData", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleTypeChargesEntity> fetchServiceTableDetails() {
		System.out.println("333333333");

		return vehicleservice.getAllServiceTableDetails();

	}
	// methods for service types ends //

	// delete method for vehicle type
	@GetMapping("/deleteById")
	@ResponseBody()
	public void deleteVehicleTypeById(@RequestParam("vehicleid") Long vehicleid) {
		vehicleservice.deleteById(vehicleid);

	}

//	@GetMapping("/deleteServiceById")
//	@ResponseBody
//    public void deleteServiceTypeById(@RequestParam("serviceid") Long serviceid) {
//		
//		System.out.println("service");
//    	vehicleservice.deleteById(serviceid);
//    }

	@GetMapping("/deleteServiceById")
	@ResponseBody
	public void deleteServiceTypeById(Long id, Model model) {

		vehicleservice.deleteServiceById(id);
	}

	// delete methos for newbooking
	@GetMapping("/delete_detailsBy_Id")
	@ResponseBody
	public void deleteVehicleDetailsById(Long id, Model model) {

		vehicleservice.deletevehicleDetailsById(id);
	}

	// get Vehicle list dynamically for vehicle charges modal

	@RequestMapping(value = "/VehicleType-API", method = RequestMethod.POST)
	@ResponseBody
	public List<VehicleTypesEntity> vehicleList() {
		List<VehicleTypesEntity> list = vehicleservice.findVehicleList();
		System.err.println("list vehicle: " + list);
		return list;
	}

	@RequestMapping(value = "/VehicleTypeDetails-API", method = RequestMethod.POST)
	@ResponseBody
	public List<VehicleTypeChargesEntity> allVehicleList() {
		List<VehicleTypeChargesEntity> list = vehicleservice.findAllVehicleList();
		System.out.println("list vehicle: " + list);
		return list;
	}

	// methos for serviceTypeCharges imp for get charges dtls 
	  @RequestMapping(value = "/getCharges", method = RequestMethod.GET)
	  
	  @ResponseBody 
	  public String getAllServiceCharges(String vehicleType, String charge) throws IOException { 
		   
		  System.err.println("vehicleType   "+vehicleType);
		  System.err.println("charge   "+charge);
		  	  
	      VehicleTypeChargesEntity vehiclecharge = vehicleservice.gettingAllServiceCharges(vehicleType);
		  
		  System.err.println("value   "+vehiclecharge);
		  
		  if(vehicleType.equals("Full Service") ) {
			  
			  return vehiclecharge.getFullCharges();
			  
		  }
		  else {
			  
			  return vehiclecharge.getRegularCharges();
			  
		  }
	  	  
	  }
	 
		
	

	// for getting vehicle details data(table)
	@RequestMapping(value = "/getAllTableDetails", method = RequestMethod.GET)
	@ResponseBody
	List<VehicleDetailsEntity> getVehicleDetails() {

		System.out.println("getting details");
		List<VehicleDetailsEntity> list1 = vehicleservice.findAll1();
		return list1;

	}

	// method for retriving data (in new Booking)
	@RequestMapping(value = "/editById", method = RequestMethod.GET)
	@ResponseBody
	public VehicleDetailsEntity editDetails(Long id) {

		System.out.println("retrive details");

		// return (VehicleDetailsEntity) vehicleservice.findAllVehicleDetailsById(id);
		return this.vehicleservice.findAllVehicleDetailsById(id);
	}

	// method for updating vehicle details table(in new booking)

	@RequestMapping(value = "/updateVehicleDetails", method = RequestMethod.POST)
	@ResponseBody
	public void saveDetails(Long id, String name, String mobileNumber, String vehicleRegisterNumber,
			String vehicleTypes, String noOfVehicles, String serviceTypes, String serviceCharges, String avaliableSlots,
			String status) {

		VehicleDetailsEntity vh1 = new VehicleDetailsEntity();
		vh1.setId(id);
		vh1.setVehicleRegisterNumber(vehicleRegisterNumber);
		vh1.setName(name);
		vh1.setMobileNumber(mobileNumber);
		vh1.setVehicleTypes(vehicleTypes);
		// vh1.setNoOfVehicles(noOfVehicles);
		vh1.setServiceTypes(serviceTypes);
		vh1.setServiceCharges(serviceCharges);
		vh1.setAvaliableSlots(avaliableSlots);
		// vh1.setStatus(status);

		vehicleservice.save(vh1);

	}

	// for editing data in servicetypes
	@RequestMapping(value = "/editServiceById", method = RequestMethod.GET)
	@ResponseBody
	public VehicleTypeChargesEntity editServiceDetails(Long id) {

		System.out.println("details");
		return vehicleservice.findAllServiceTypeDetailsById(id);

	}

	// for in servicetypes edit/(updating data/save data)

	@RequestMapping(value = "/updateServiceTypeDetails", method = RequestMethod.POST)
	@ResponseBody
	// public void saveServiceDetails(Long id, String serviceTypes, String
	// serviceCharges) {
	public void saveServiceDetails(Long id, String fullCharges, String regularCharges, String vehicleType) {

		VehicleTypeChargesEntity s1 = new VehicleTypeChargesEntity();
		s1.setId(id);
		s1.setVehicleType(vehicleType);
		// s1.setVehicleName(vName);
		s1.setFullCharges(fullCharges);
		s1.setRegularCharges(regularCharges);
		// s1.setServiceTypes(serviceTypes);
		// s1.setServiceCharges(serviceCharges);

		vehicleservice.save(s1);

	}

	// for in AboutUs edit/(updating data/save data)

	@RequestMapping(value = "/updateAboutData", method = RequestMethod.POST)
	@ResponseBody
	public void saveAboutUsDetails(Long id, String header, String image, String description) {

		// System.out.println("inside about us");
		AboutUsEntity Ae1 = new AboutUsEntity();
		Ae1.setId(id);
		Ae1.setHeader(header);
		Ae1.setImage(image);
		Ae1.setDescription(description);

		vehicleservice.save(Ae1);

	}

	// for editing data in vehicletypes
	@RequestMapping(value = "/editVehicleById", method = RequestMethod.GET)
	@ResponseBody
	public VehicleTypesEntity editVehicleDetails(Long id) {
		return vehicleservice.findAllVehicleDetailById(id);

	}

	// for in vehicletypes edit/(updating data/save data)

	@RequestMapping(value = "/updateVehicleTypeDetails", method = RequestMethod.POST)
	@ResponseBody
	public void saveVehicleDetails(Long id, String vehicleTypes) {
		VehicleTypesEntity v1 = new VehicleTypesEntity();
		v1.setId(id);
		v1.setVehicleType(vehicleTypes);
		vehicleservice.save(v1);
	}

	/*
	 * public void vehicleType(VehicleTypesEntity vh) {
	 * 
	 * System.out.println("hiii...");
	 * 
	 * vehicleservice.vehicleTypes(vh);
	 * 
	 * }
	 */

	// for admin login
	@RequestMapping("/customer_login")
	public String ValidLogIn(RedirectAttributes redirectAttributes, HttpServletRequest request, HttpSession session,
			@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		System.out.println("111111111111");

		File f = new File(uploadProductDirectory);
		if (!f.exists()) {
			f.mkdirs();
		}

		CustomerRegistrationEntity customerRegistrationEntity = vehicleservice.getEmailPassword(email, password);
		if (customerRegistrationEntity != null) {
			System.out.println("2222222222");
			if (customerRegistrationEntity.getStatus().equals("Active")
					&& customerRegistrationEntity.getRole().equals("Admin")) {

				session.setAttribute("id", customerRegistrationEntity.getId());
				session.setAttribute("name", customerRegistrationEntity.getName());
				session.setAttribute("address", customerRegistrationEntity.getAddress());
				session.setAttribute("phoneNo", customerRegistrationEntity.getPhoneNo());
				session.setAttribute("email", customerRegistrationEntity.getEmail());
				// session.setAttribute("password", customerRegistrationEntity.getPassword());
				session.setAttribute("role", customerRegistrationEntity.getRole());
				session.setAttribute("login", customerRegistrationEntity.getId());
				System.out.println("annnnnnnn");

				return "comman/layout";

				// return "comman/webindex";
			} else if (customerRegistrationEntity.getStatus().equals("Active")
					&& customerRegistrationEntity.getRole().equals("Employee")) {

				session.setAttribute("id", customerRegistrationEntity.getId());
				session.setAttribute("name", customerRegistrationEntity.getName());
				session.setAttribute("address", customerRegistrationEntity.getAddress());
				session.setAttribute("phoneNo", customerRegistrationEntity.getPhoneNo());
				session.setAttribute("email", customerRegistrationEntity.getEmail());
				// session.setAttribute("password", customerRegistrationEntity.getPassword());
				session.setAttribute("role", customerRegistrationEntity.getRole());
				session.setAttribute("login", customerRegistrationEntity.getId());
				System.out.println("kkkkkkk");

				return "comman/layout";

				// model.addAttribute("message", "Invalid, try again..");
				// return "login";
			}

		} else {
			System.out.println("kkkkkkk");
			return "redirect:/web ";
		}
		System.out.println("wwwwww");
		return "redirect:/web ";

	}

	// method for
	@RequestMapping(value = "/add_about_us", method = RequestMethod.POST)
	@ResponseBody
	public void AppAboutUs(AboutUsEntity about, BindingResult bindingResult, HttpSession session,
			RedirectAttributes redireAttributes, @RequestParam("image") MultipartFile image) throws IOException {

		System.err.println("aaaa");
		if (!image.isEmpty() && image != null) {

			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + image.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, image.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			about.setImage(originalFileName);
		} else {

			about.setImage(" ");
		}

		vehicleservice.saveAboutUs(about);
	}
	
	
	
	
	
	
	
	
	// method for saving add team member and img
		@RequestMapping(value = "/add_team_API", method = RequestMethod.POST)
		@ResponseBody
		public void addTeam(AddTeam ateam, BindingResult bindingResult, HttpSession session,
				RedirectAttributes redireAttributes, @RequestParam("image") MultipartFile image) throws IOException {

			System.err.println("adding team");
			if (!image.isEmpty() && image != null) {

				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-" + image.getOriginalFilename().replace(" ", "-").toLowerCase();

				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

				try {
					Files.write(fileNameAndPath, image.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				ateam.setImage(originalFileName);
			} else {

				ateam.setImage(" ");
			}

			vehicleservice.saveAddTeam(ateam);
		}

	
	
	
	
	
	
	
	
	

	// method for updating status in admin pannel ...here we sending id, and status.
	@RequestMapping(value = "/Update_Status", method = RequestMethod.POST)
	@ResponseBody
	public void updateStatus(Long id, String status) {

		System.out.println("updating  status" + id + " " + status);
		vehicleservice.findStatusById(id, status);

	}

	/*
	 * @RequestMapping(value = "/Update_InprocessData", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public List<VehicleDetailsEntity> updateInprocessData() {
	 * 
	 * List<VehicleDetailsEntity> allLists = vehicleservice.processData(); // get
	 * all the VehicleDetailsEntity objects
	 * 
	 * for (VehicleDetailsEntity list : allLists) { String statusData =
	 * list.getStatus(); System.out.println(list);
	 * 
	 * if ("In-Process".equals(statusData)) { List<VehicleDetailsEntity>
	 * inProcessLists = new ArrayList<>(); // create a new ArrayList
	 * 
	 * inProcessLists.add(list); // add the object to the list
	 * 
	 * System.err.println("fythgfg      " + inProcessLists);
	 * 
	 * return inProcessLists;
	 * 
	 * } else if ("Cancel".equals(statusData)) {
	 * 
	 * List<VehicleDetailsEntity> inProcessLists2 = new ArrayList<>(); // create a
	 * new ArrayList
	 * 
	 * inProcessLists2.add(list); // add the object to the list
	 * 
	 * return inProcessLists2;
	 * 
	 * } }
	 * 
	 * return null; }
	 * 
	 */
	
	
	
	// Method for updating status in new order admin pannel
		@RequestMapping(value = "/Update_New_Orders", method = RequestMethod.GET)
		@ResponseBody
		public List<VehicleDetailsEntity> updateNewOrders() {

		    List<VehicleDetailsEntity> allLists = vehicleservice.processData(); // get all the VehicleDetailsEntity objects

		    List<VehicleDetailsEntity> inProcessLists = new ArrayList<>(); // create a new ArrayList

		    for (VehicleDetailsEntity list : allLists) {
		        String statusData = list.getStatus();
		        System.out.println(list);

		        if ("Pending".equals(statusData)) {
		            inProcessLists.add(list); // add the object to the list
		        } else if ("Cancel".equals(statusData)) {
		            inProcessLists.add(list); // add the object to the list
		        }
		    }

		    System.err.println("fythgfg      " + inProcessLists);
		    return inProcessLists;
		}
	
	
	
	
	
	
	
	// Method for updating status inprocess admin pannel
	@RequestMapping(value = "/Update_InprocessData", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleDetailsEntity> updateInprocessData() {

	    List<VehicleDetailsEntity> allLists = vehicleservice.processData(); // get all the VehicleDetailsEntity objects

	    List<VehicleDetailsEntity> inProcessLists = new ArrayList<>(); // create a new ArrayList

	    for (VehicleDetailsEntity list : allLists) {
	        String statusData = list.getStatus();
	        System.out.println(list);

	        if ("In-Process".equals(statusData)) {
	            inProcessLists.add(list); // add the object to the list
	        } else if ("Cancel".equals(statusData)) {
	            inProcessLists.add(list); // add the object to the list
	        }
	    }

	    System.err.println("fythgfg      " + inProcessLists);
	    return inProcessLists;
	}

	// method for updating status "cancle" orders in admin pannel
	@RequestMapping(value = "/cancel_order", method = RequestMethod.GET)
	@ResponseBody
	public List<VehicleDetailsEntity> cancelOrder() {

	    List<VehicleDetailsEntity> allLists = vehicleservice.processData(); // get all the VehicleDetailsEntity objects

	    List<VehicleDetailsEntity> inProcessLists = new ArrayList<>(); // create a new ArrayList

	    for (VehicleDetailsEntity list : allLists) {
	        String statusData = list.getStatus();
	        
	        System.out.println(list);

	        if ("Cancle".equals(statusData)) {
	        	
	            inProcessLists.add(list); // add the object to the list
	        }
	    }

	    System.err.println("fythgfg      " + inProcessLists);
	    return inProcessLists;
	}
	
	
	
	// method for updating status "order completed" orders in admin pannel
		@RequestMapping(value = "/order_Completed", method = RequestMethod.GET)
		@ResponseBody
		public List<VehicleDetailsEntity> orderCompleted() {

		    List<VehicleDetailsEntity> allLists = vehicleservice.processData(); // get all the VehicleDetailsEntity objects

		    List<VehicleDetailsEntity> inProcessLists = new ArrayList<>(); // create a new ArrayList

		    for (VehicleDetailsEntity list : allLists) {
		        String statusData = list.getStatus();
		        
		        System.out.println(list);

		        if ("Completed".equals(statusData)) {
		        	
		            inProcessLists.add(list); // add the object to the list
		        }
		    }

		    System.err.println("fythgfg      " + inProcessLists);
		    return inProcessLists;
		}

		
	

	
		/*
		 * @RequestMapping(value = "/Order_Counts", method = RequestMethod.POST)
		 * 
		 * @ResponseBody public Long coundComplateOrders() {
		 * 
		 * String status ="Completed";
		 * 
		 * Long coundComplateOrders = vehicleservice.coundComplateOrders(status);
		 * System.err.println(coundComplateOrders);
		 * 
		 * 
		 * return coundComplateOrders;
		 * 
		 * 
		 * }
		 */	
	
	

		/*
		 * @RequestMapping(value = "/Order_Count", method = RequestMethod.POST)
		 * 
		 * @ResponseBody public DashBoardJsonResponse countComplateOrders() {
		 * 
		 * DashBoardJsonResponse response = new DashBoardJsonResponse();
		 * 
		 * response.setNewOrder(vehicleservice.getNewOrderCount());
		 * 
		 * // return response; }
		 */
		
		
		
		 @RequestMapping(value = "/Order_Counts", method = RequestMethod.POST)
		  @ResponseBody
		public DashBoardJsonResponse countComplateOrders() {
			
			DashBoardJsonResponse response = new DashBoardJsonResponse();
			 response.setNewOrder(vehicleservice.getNewOrderCount());
			 response.setOrderInProcess(vehicleservice.getOrderInProcessCount());
			 response.setOrderComplete(vehicleservice.getOrderCompletedCount());
			 response.setCancleOrder(vehicleservice.getCancleOrders());
			 response.setFindAllOrder(vehicleservice.getAllOrders());
			 System.err.println("response" +response );
			return response;
		    }
		 
		 
		   
		 
		}
			
	
	
	
	/*
	 * @RequestMapping(value="/Update_Status",method = RequestMethod.GET)
	 * 
	 * @ResponseBody public void updateStatusBy(Long id, String status) {
	 * 
	 * System.out.println("aaaa"); vehicleservice.findStatusById(id,status); return
	 * ;
	 * 
	 * }
	 */


