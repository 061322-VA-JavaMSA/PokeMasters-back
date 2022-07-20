package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trades")
public class Trade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="pokemon_id", nullable=false)
	private int pokemonId;
	@Column(nullable=true)
	private int level;
	@Column(name="requested_id", nullable=false)
	private int requestedId;
	@Column(nullable=false)
	private int range;
	
	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPokemonId() {
		return pokemonId;
	}
	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}
	public int getRequestedId() {
		return requestedId;
	}
	public void setRequestedId(int requestedId) {
		this.requestedId = requestedId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, level, pokemonId, range, requestedId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return id == other.id && level == other.level && pokemonId == other.pokemonId && range == other.range
				&& requestedId == other.requestedId;
	}
	@Override
	public String toString() {
		return "Trade [id=" + id + ", pokemonId=" + pokemonId + ", level=" + level + ", requestedId=" + requestedId
				+ ", range=" + range + "]";
	}
	
	
}
