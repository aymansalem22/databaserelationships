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

@Entity
public class TournamentV2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "tournament_id")
	private List<RegistrationV2> registrations = new ArrayList<>();

	public void addRegistration(RegistrationV2 reg) {
		registrations.add(reg);
	}

	public void removeRegistration(RegistrationV2 reg) {
		if (registrations != null) {
			registrations.remove(reg);
		}
	}

	public TournamentV2() {

	}

	public TournamentV2(String name, String location) {
		this.name = name;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<RegistrationV2> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(List<RegistrationV2> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Tournament [id=" + id + ", name=" + name + ", location=" + location + ", registrations=" + registrations
				+ "]";
	}

}
