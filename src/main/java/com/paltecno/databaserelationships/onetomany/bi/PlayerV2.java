package com.paltecno.databaserelationships.onetomany.bi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayerV2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name = "profile_id", referencedColumnName = "id")
	// @JsonManagedReference
	private PlayerProfileV2 playerProfile;

	@OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
	private List<RegistrationV2> registrations = new ArrayList<>();

	public void registerPlayer(RegistrationV2 reg) {
		registrations.add(reg);
		reg.setPlayer(this);
	}

	public void removeRegistration(RegistrationV2 reg) {
		if (registrations != null)
			registrations.remove(reg);
		reg.setPlayer(null);

	}

	public PlayerV2() {

	}

	public PlayerV2(String name) {
		super();
		this.name = name;

	}

	public PlayerV2(String name, PlayerProfileV2 playerProfile) {
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

	public PlayerProfileV2 getPlayerProfile() {
		return playerProfile;
	}

	public void setPlayerProfile(PlayerProfileV2 playerProfile) {
		this.playerProfile = playerProfile;
	}

	public List<RegistrationV2> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<RegistrationV2> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", playerProfile=" + playerProfile + ", registrations="
				+ registrations + "]";
	}

}
