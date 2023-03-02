package com.paltecno.databaserelationships.onetomany.bi;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayerProfileV2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String twitter;

	@OneToOne(mappedBy = "playerProfile", cascade = CascadeType.ALL)
	// @JsonBackReference
	private PlayerV2 player;

	public PlayerProfileV2() {
		super();
	}

	public PlayerProfileV2(String twitter) {
		super();
		this.twitter = twitter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public PlayerV2 getPlayer() {
		return player;
	}

	public void setPlayer(PlayerV2 player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "PlayerProfile [id=" + id + ", twitter=" + twitter + ", player=" + player + "]";
	}

}
