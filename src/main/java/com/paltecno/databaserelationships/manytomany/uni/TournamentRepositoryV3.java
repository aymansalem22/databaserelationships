package com.paltecno.databaserelationships.manytomany.uni;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepositoryV3 extends JpaRepository<TournamentV3, Integer> {

}
