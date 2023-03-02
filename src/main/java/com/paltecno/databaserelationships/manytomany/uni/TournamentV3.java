package com.paltecno.databaserelationships.manytomany.uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.paltecno.databaserelationships.onetomany.bi.RegistrationV2;

@Entity
public class TournamentV3 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "tournament_id")
	private List<RegistrationV2> registrations = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "tournament_categories", joinColumns = @JoinColumn(name = "tournament_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> playingCategories = new ArrayList<>();

	public void addCategory(Category category) {
		playingCategories.add(category);
	}

	public void removeCategory(Category category) {
		if (playingCategories != null)
			playingCategories.remove(category);
	}

	public void addRegistration(RegistrationV2 reg) {
		registrations.add(reg);
	}

	public void removeRegistration(RegistrationV2 reg) {
		if (registrations != null) {
			registrations.remove(reg);
		}
	}

	public TournamentV3() {

	}

	public TournamentV3(String name, String location, List<RegistrationV2> registrations) {
		super();
		this.name = name;
		this.location = location;
		this.registrations = registrations;
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

	public List<Category> getPlayingCategories() {
		return playingCategories;
	}

	public void setPlayingCategories(List<Category> playingCategories) {
		this.playingCategories = playingCategories;
	}

	@Override
	public String toString() {
		return "TournamentV3 [id=" + id + ", name=" + name + ", location=" + location + ", registrations="
				+ registrations + ", playingCategories=" + playingCategories + "]";
	}

}
