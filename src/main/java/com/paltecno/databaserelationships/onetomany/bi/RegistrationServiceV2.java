package com.paltecno.databaserelationships.onetomany.bi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceV2 {

	@Autowired
	RegistrationRepositoryV2 repoV2;

	public List<RegistrationV2> allRegistrations() {
		return repoV2.findAll();
	}

	public RegistrationV2 getRegistration(int id) {
		return repoV2.findById(id).get();
	}

	public RegistrationV2 addRegistration(RegistrationV2 registration) {
		registration.setId(0);
		return repoV2.save(registration);
	}

	public void deleteRegistration(int id) {
		repoV2.deleteById(id);
	}

}
