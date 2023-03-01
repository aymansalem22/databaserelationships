package com.paltecno.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paltecno.databaserelationships.onetoone.PlayerProfile;

@Repository
public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, Integer> {

}
