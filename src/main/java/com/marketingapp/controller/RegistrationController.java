package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.RegistrationDto;
import com.marketingapp.entity.Registration;
import com.marketingapp.service.RegistrationService;
import com.marketingapp.util.EmailService;

@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private EmailService emailService;
	//http://localhost:8080/views
	
	//Handeler Method	: These method are used to interact with front and backend of the application.
//						The return type of handler method is String and @RequestMapping("/....") must be written here
					
	@RequestMapping("/views")	// It is just like @webServelet("/...")
	public String viewRegistration() {
		
		return "create_lead";	//redirects the page to the jsp file whose name is create_lead.
	}
	
	//mrthod 1 to save data into table
	
//	@RequestMapping("/saveReg")
//	public String saveRegistration(Registration regs) {
////		System.out.println("Id : "+regs.getId());
////		System.out.println("First Name: "+regs.getFirstName());
////		System.out.println("Last Name : "+regs.getLastName());
////		System.out.println("Email : "+regs.getEmail());
////		System.out.println("Mobile : "+regs.getMobile());
//		
//		registrationService.saveRegistration(regs);
//		
//		return "create_lead";
//	}
	
	//2nd way  to read and insert data
//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("lastName") String lastName,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") String mobile
//			) {
//		Registration reg=new Registration();
//		
//		reg.setFirstName(firstName);
//		reg.setLastName(lastName);
//		reg.setEmail(email);
//		reg.setMobile(mobile);
//		
//		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(mobile);
//
//		registrationService.saveRegistration(reg);
//		
//		return "create_lead";
//	}
	
	
	//3rd way to read and insert data
	
	@RequestMapping("/saveReg")
	public String saveRegistration(RegistrationDto dto, Model model) {
		Registration reg=new Registration();
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
		registrationService.saveRegistration(reg);
		String welcome="Thank You for Your Submission!";
		String message="Dear, "+ dto.getFirstName()+ "\n\nI hope this message finds you well. We wanted to express our sincere gratitude for taking the time to complete the form. Your input is invaluable to us, and we appreciate your effort in providing the necessary information.\r\n"
				+ "\r\n"
				+ "Our team is now diligently reviewing the details you've submitted. Should there be any additional information required or if we have further questions, we will not hesitate to reach out to you promptly.\r\n"
				+ "\r\n"
				+ "Thank you once again for your participation. We look forward to the opportunity to connect with you further and appreciate your interest in [Your Company/Organization].\r\n"
				+ "\r\n"
				+ "If you have any immediate questions or concerns, please feel free to contact us at [Your Contact Information].";
				
		
		emailService.sendEmail(dto.getEmail(), welcome, message);
		
		
		System.out.println("Data inserted Successfully!!");
		
		model.addAttribute("msg", "Data inserted Successfully!!");
		
		return "create_lead";
	}
	
	
	@RequestMapping("/getAllReg")
	public String getAllRegistrations(Model model) {
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations", registrations);
//		System.out.println(registrations);
		return "List_registrations";
	}
	
	@RequestMapping("/delete")
	public String deleteId(@RequestParam Long id,Model model) {
		registrationService.deleteId(id);
		
		List<Registration> registrations = registrationService.getAllRegistrations();
		model.addAttribute("registrations", registrations);
		
		return "List_registrations";
		
	}
	
	
	
	
}
