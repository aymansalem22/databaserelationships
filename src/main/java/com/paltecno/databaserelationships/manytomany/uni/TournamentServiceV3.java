package com.paltecno.databaserelationships.manytomany.uni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paltecno.databaserelationships.onetomany.bi.RegistrationV2;

@Service
public class TournamentServiceV3 {

	@Autowired
	private TournamentRepositoryV3 repo;

	public List<TournamentV3> allTournaments() {
		return repo.findAll();
	}

	public TournamentV3 getTournament(int id) {
		return repo.findById(id).get();
	}

	public TournamentV3 addTournament(TournamentV3 tournament) {
		tournament.setId(0);
		return repo.save(tournament);
	}

	public void deleteTournament(int id) {
		repo.deleteById(id);
	}

	public TournamentV3 addRegistration(int id, RegistrationV2 registration) {
		TournamentV3 tournament = repo.findById(id).get();
		tournament.addRegistration(registration);
		return repo.save(tournament);
	}

	public TournamentV3 removeRegistration(int id, RegistrationV2 registration) {
		TournamentV3 tournament = repo.findById(id).get();
		tournament.removeRegistration(registration);

		return repo.save(tournament);
	}

	public TournamentV3 addCategory(int id, Category category) {
		TournamentV3 tournament = repo.findById(id).get();
		tournament.addCategory(category);
		return repo.save(tournament);
	}

	public TournamentV3 removeCategory(int id, Category category) {
		TournamentV3 tournament = repo.findById(id).get();
		tournament.removeCategory(category);
		return repo.save(tournament);
	}
}
