package com.paltecno.databaserelationships.onetomany.bi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playersv2")
public class PlayerControllerV2 {

	@Autowired
	PlayerServiceV2 playerServiceV2;

	@Autowired
	PlayerProfileServiceV2 profileServiceV2;

	@Autowired
	RegistrationServiceV2 registrationServiceV2;

	@GetMapping
	public List<PlayerV2> allPlayers() {
		return playerServiceV2.allPlayers();
	}

	@GetMapping("/{id}")
	public PlayerV2 getPlayer(@PathVariable int id) {
		return playerServiceV2.getPlayer(id);
	}

	@PostMapping
	public PlayerV2 addPlayer(@RequestBody PlayerV2 player) {
		return playerServiceV2.addPlayer(player);
	}

	@DeleteMapping("/{id}")
	public void deletePlayer(@PathVariable int id) {
		playerServiceV2.deletePlayer(id);
	}

	@PutMapping("/{id}/profiles/{profile_id}")
	public PlayerV2 assignDetails(@PathVariable int id, @PathVariable int profile_id) {
		PlayerProfileV2 profile = profileServiceV2.getPlayerProfile(profile_id);
		System.out.println(profile);
		return playerServiceV2.assignProfile(id, profile);

	}

	@PutMapping("/{id}/registrations/{registration_id}")
	public PlayerV2 assignRegistration(@PathVariable int id, @PathVariable int registration_id) {
		RegistrationV2 registration = registrationServiceV2.getRegistration(registration_id);
		return playerServiceV2.assignRegistration(id, registration);
	}

	@PutMapping("/{id}/remove_registration/{registration_id}")
	public PlayerV2 removeRegistration(@PathVariable int id, @PathVariable int registration_id) {
		RegistrationV2 registration = registrationServiceV2.getRegistration(registration_id);
		System.out.println(registration);
		return playerServiceV2.removeRegistration(id, registration);

	}

}
