package com.paltecno.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paltecno.databaserelationships.onetomany.uni.Registration;
import com.paltecno.databaserelationships.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;

	public List<Registration> getAllRegistrations() {
		return repo.findAll();
	}

	public Registration getRegistration(int id) {
		return repo.findById(id).get();
	}

	public Registration addRegistration(Registration registration) {
		registration.setId(0);
		return repo.save(registration);
	}

	public void deleteRegistration(int id) {
		repo.deleteById(id);
	}

}
