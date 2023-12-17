package com.marketingapp.restapi;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Repository.Repository;
import com.marketingapp.entity.Registration;

import antlr.collections.List;

				//1) when you mark a class as @RestController, the complete setup to the api is done
@RestController	//2.) This rest controller comes from spring web dependency
@RequestMapping("/api/registrations")
public class RegistrationRestController {
	
	@Autowired
	private Repository registrationRepo;
	
	//http://localhost:8080/api/registraitons
	@GetMapping
	public java.util.List<Registration> getAll(){
		java.util.List<Registration> reg = registrationRepo.findAll();
		return reg;
	}
	
	
	
//	@GetMapping
//	public List<Registration> getAllReg(){
//		List<Registration> reg=registrationRepo.findAll();
//		return reg;
//		
//	}
	
//	http://localhost:8080/api/registraitons
	@PostMapping
	public void saveRegistrations(@RequestBody Registration regis) {
		registrationRepo.save(regis);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		registrationRepo.deleteById(id);
		
	}
	
	@PutMapping("/{id}")
	public void updateRegistration(@PathVariable long id, @RequestBody Registration regis) {
		Optional<Registration> findById = registrationRepo.findById(id);
		Registration reg = findById.get();
		reg.setFirstName(regis.getFirstName());
		reg.setLastName(regis.getLastName());
		reg.setEmail(regis.getEmail());
		reg.setMobile(regis.getMobile());
		
		registrationRepo.save(reg);
	}


	
}

