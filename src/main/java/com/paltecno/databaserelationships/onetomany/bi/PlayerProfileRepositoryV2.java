package com.paltecno.databaserelationships.onetomany.bi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerProfileRepositoryV2 extends JpaRepository<PlayerProfileV2, Integer> {

}
