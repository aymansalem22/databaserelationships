package com.paltecno.databaserelationships.manytomany.uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

	@Id
	@GeneratedValue
	private int id;

	@Column(unique = true)
	private String name;

	@ManyToMany(mappedBy = "playingCategories", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JsonIgnoreProperties("playingCategories")
	private List<TournamentV3> tournaments = new ArrayList<>();

	public Category() {

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

	public List<TournamentV3> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<TournamentV3> tournaments) {
		this.tournaments = tournaments;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", tournaments=" + tournaments + "]";
	}

}
