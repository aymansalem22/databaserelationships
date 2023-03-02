package com.paltecno.databaserelationships.onetomany.bi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrationsv2")
public class RegistrationControllerV2 {

	@Autowired
	RegistrationServiceV2 serviceV2;

	@GetMapping
	public List<RegistrationV2> allRegistrations() {
		return serviceV2.allRegistrations();
	}

	@GetMapping("/{id}")
	public RegistrationV2 getRegistration(@PathVariable int id) {
		return serviceV2.getRegistration(id);
	}

	@PostMapping
	public RegistrationV2 addRegistration(@RequestBody RegistrationV2 registration) {
		return serviceV2.addRegistration(registration);
	}

	@DeleteMapping("/{id}")
	public void deleteRegistration(@PathVariable int id) {
		serviceV2.deleteRegistration(id);
	}
}
