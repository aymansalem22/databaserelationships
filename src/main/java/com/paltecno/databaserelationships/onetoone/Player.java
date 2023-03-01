package com.paltecno.databaserelationships.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	// @JsonManagedReference
	private PlayerProfile playerProfile;

	public Player() {
		super();
	}

	public Player(String name, PlayerProfile playerProfile) {
		super();
		this.name = name;
		this.playerProfile = playerProfile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlayerProfile getPlayerProfile() {
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfile playerProfile) {
		this.playerProfile = playerProfile;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", playerProfile=" + playerProfile + "]";
	}

}
