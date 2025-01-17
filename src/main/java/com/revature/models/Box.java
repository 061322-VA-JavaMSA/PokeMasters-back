package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "boxes")
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OrderColumn
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "box_id")
	private Pokemon[] pokemon = new Pokemon[30];

	public Box() {
		super();
		// TODO Auto-generated constructor stub
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

	public Pokemon[] getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon[] pokemon) {
		this.pokemon = pokemon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(pokemon);
		result = prime * result + Objects.hash(id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		return id == other.id && Objects.equals(name, other.name) && Arrays.equals(pokemon, other.pokemon);
	}

	@Override
	public String toString() {
		return "Box [id=" + id + ", name=" + name + ", pokemon=" + Arrays.toString(pokemon) + "]";
	}

}
