package com.paltecno.databaserelationships.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paltecno.databaserelationships.onetoone.Player;
import com.paltecno.databaserelationships.onetoone.PlayerProfile;
import com.paltecno.databaserelationships.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	PlayerRepository repo;

	public List<Player> allPlayers() {
		return repo.findAll();
	}

	public Player addPlayer(Player player) {
		player.setId(0);
		return repo.save(player);
	}

	public Player getPlayer(int id) {

		return repo.findById(id).get();
	}

	public void deletePlayer(int id) {
		repo.deleteById(id);
	}

	public Player assignPrfile(int id, PlayerProfile profile) {
		Player player = repo.findById(id).get();
		player.setPlayerProfile(profile);
		return repo.save(player);
	}

}
