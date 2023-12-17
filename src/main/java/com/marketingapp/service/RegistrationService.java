package com.marketingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.RegistrationRepository;
import com.marketingapp.Repository.Repository;
import com.marketingapp.entity.Registration;

@Service
public class RegistrationService {

	@Autowired
	private Repository repo;

	public void saveRegistration(Registration registration) {
		repo.save(registration);
	}

	public List<Registration> getAllRegistrations() {
		List<Registration> registrations = repo.findAll();
		return registrations;
	}

	public void deleteId(Long id) {
		repo.deleteById(id);
	}
	
}
