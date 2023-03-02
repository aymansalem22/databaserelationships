package com.paltecno.databaserelationships.onetomany.bi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerProfileServiceV2 {

	@Autowired
	PlayerProfileRepositoryV2 repoV2;

	public List<PlayerProfileV2> allPlayerProfiles() {
		return repoV2.findAll();
	}

	public PlayerProfileV2 getPlayerProfile(int id) {
		return repoV2.findById(id).get();
	}

	public PlayerProfileV2 addPlayerProfile(PlayerProfileV2 profile) {
		profile.setId(0);
		return repoV2.save(profile);
	}

	public void deletePlayerProfile(int id) {
		repoV2.deleteById(id);
	}

}
