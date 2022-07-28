package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "parties")
public class Party {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OrderColumn
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "party_id")
	private List<Pokemon> pokemon = new ArrayList<>();
	@OneToOne
	@JoinColumn(name="trainer")
	private Trainer trainer;
	public Party() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Pokemon> getPokemon() {
		return pokemon;
	}
	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, pokemon, trainer);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party other = (Party) obj;
		return id == other.id && Objects.equals(pokemon, other.pokemon) && Objects.equals(trainer, other.trainer);
	}
	@Override
	public String toString() {
		return "Party [id=" + id + ", pokemon=" + pokemon + ", trainer=" + trainer + "]";
	}
	
	
}
