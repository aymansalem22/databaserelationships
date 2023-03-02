package com.paltecno.databaserelationships.onetomany.bi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceV2 {

	@Autowired
	private PlayerRepositoryV2 repoV2;

	public List<PlayerV2> allPlayers() {
		return repoV2.findAll();
	}

	public PlayerV2 getPlayer(int id) {
		return repoV2.findById(id).get();
	}

	public PlayerV2 addPlayer(PlayerV2 player) {
		player.setId(0);
		if (player.getPlayerProfile() != null) {
			player.getPlayerProfile().setPlayer(player);
		}
		return repoV2.save(player);
	}

	public void deletePlayer(int id) {
		repoV2.deleteById(id);
	}

	public PlayerV2 assignProfile(int id, PlayerProfileV2 profile) {
		PlayerV2 player = repoV2.findById(id).get();
		player.setPlayerProfile(profile);
		player.getPlayerProfile().setPlayer(player);
		return repoV2.save(player);
	}

	public PlayerV2 assignRegistration(int id, RegistrationV2 registration) {
		PlayerV2 player = repoV2.findById(id).get();
		player.registerPlayer(registration);
		return repoV2.save(player);
	}

	public PlayerV2 removeRegistration(int id, RegistrationV2 registration) {
		PlayerV2 player = repoV2.findById(id).get();
		player.removeRegistration(registration);
		return repoV2.save(player);

	}
}
