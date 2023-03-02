package com.paltecno.databaserelationships.manytomany.uni;

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

import com.paltecno.databaserelationships.onetomany.bi.RegistrationServiceV2;
import com.paltecno.databaserelationships.onetomany.bi.RegistrationV2;

@RestController
@RequestMapping("/tournamentsv3")
public class TournamentControllerV3 {

	@Autowired
	TournamentServiceV3 tournamentService;

	@Autowired
	RegistrationServiceV2 registrationService;

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public List<TournamentV3> allTournaments() {
		return tournamentService.allTournaments();
	}

	@GetMapping("/{id}")
	public TournamentV3 getTournament(@PathVariable int id) {
		return tournamentService.getTournament(id);
	}

	@PostMapping
	public TournamentV3 addTournament(@RequestBody TournamentV3 tournament) {
		return tournamentService.addTournament(tournament);
	}

	@PutMapping("/{id}/registrations/{registration_id}")
	public TournamentV3 addRegistration(@PathVariable int id, @PathVariable int registration_id) {
		RegistrationV2 registration = registrationService.getRegistration(id);
		System.out.println(registration);
		return tournamentService.addRegistration(id, registration);
	}

	@PutMapping("/{id}/remove_registrations/{registration_id}")
	public TournamentV3 removeReistration(@PathVariable int id, @PathVariable int registration_id) {
		RegistrationV2 registration = registrationService.getRegistration(registration_id);
		System.out.println(registration);
		return tournamentService.removeRegistration(id, registration);
	}

	@PutMapping("/{id}/categories/{category_id}")
	public TournamentV3 addCategory(@PathVariable int id, @PathVariable int category_id) {
		Category category = categoryService.getCategory(category_id);
		return tournamentService.addCategory(id, category);
	}

	@PutMapping("/{id}/remove_categories/{category_id}")
	public TournamentV3 removeCategory(@PathVariable int id, @PathVariable int category_id) {
		Category category = categoryService.getCategory(category_id);
		System.out.println(category);
		return tournamentService.removeCategory(id, category);
	}

	@DeleteMapping("/{id}")
	public void deleteTournament(@PathVariable int id) {
		tournamentService.deleteTournament(id);
	}

}
