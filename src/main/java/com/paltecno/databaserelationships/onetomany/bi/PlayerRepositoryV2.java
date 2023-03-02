package com.paltecno.databaserelationships.onetomany.bi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepositoryV2 extends JpaRepository<PlayerV2, Integer> {

}
