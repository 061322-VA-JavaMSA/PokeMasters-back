package com.revature.models;

import java.util.Map;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "moves")
public class Move {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private int id;
	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.STRING)
	private Type type;
	@Column(nullable = false)
	private int power;
	@Column(nullable = false)
	private int currentPP;
	@Column(nullable = false)
	private int maxPP;
	@Column(nullable = false)
	private int accuracy;
	@Enumerated(EnumType.STRING)
	private Damage damage;

	public Move() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}

	public int getPower() {
		return power;
	}

	public int getCurrentPP() {
		return currentPP;
	}

	public int getMaxPP() {
		return maxPP;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public Damage getDamage() {
		return damage;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setCurrentPP(int currentPP) {
		this.currentPP = currentPP;
	}

	public void setMaxPP(int maxPP) {
		this.maxPP = maxPP;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public void setDamage(Damage damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Move [id=" + id + ", name=" + name + ", type=" + type + ", power=" + power + ", currentPP=" + currentPP
				+ ", maxPP=" + maxPP + ", accuracy=" + accuracy + ", damage=" + damage + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accuracy, currentPP, damage, id, maxPP, name, power, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		return accuracy == other.accuracy && currentPP == other.currentPP && damage == other.damage && id == other.id
				&& maxPP == other.maxPP && Objects.equals(name, other.name) && power == other.power
				&& type == other.type;
	}

	@JsonProperty("damage_class")
	public void unpackDamage(Map m) {
		damage = Damage.valueOf(m.get("name").toString().toUpperCase());
	}

	@JsonProperty("type")
	public void unpackType(Map m) {
		type = Type.valueOf(m.get("name").toString().toUpperCase());
	}
	
	@JsonProperty("pp")
	public void handlePP(int pp) {
		currentPP = pp;
		maxPP = pp;
	}
}
