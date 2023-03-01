package com.paltecno.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paltecno.databaserelationships.onetomany.uni.Tournament;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Integer> {

}
