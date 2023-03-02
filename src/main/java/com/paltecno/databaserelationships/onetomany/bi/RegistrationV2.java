package com.paltecno.databaserelationships.onetomany.bi;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RegistrationV2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "player_id", referencedColumnName = "id")
	private PlayerV2 player;

	public RegistrationV2() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PlayerV2 getPlayer() {
		return player;
	}

	public void setPlayer(PlayerV2 player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", player=" + player + "]";
	}

}
