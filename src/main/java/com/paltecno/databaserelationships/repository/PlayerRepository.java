package com.paltecno.databaserelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paltecno.databaserelationships.onetoone.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
