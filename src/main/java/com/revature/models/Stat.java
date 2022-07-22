package com.revature.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="stats")
public class Stat {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private StatType name;
	private int base;
	private double natureMod;
	public double getNatureMod() {
		return natureMod;
	}

	public void setNatureMod(double natureMod) {
		this.natureMod = natureMod;
	}

	private int iv;
	private int ev;

	public Stat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StatType getName() {
		return name;
	}

	public void setName(StatType name) {
		this.name = name;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getIv() {
		return iv;
	}

	public void setIv(int iv) {
		this.iv = iv;
	}

	public int getEv() {
		return ev;
	}

	public void setEv(int ev) {
		this.ev = ev;
	}

	@Override
	public int hashCode() {
		return Objects.hash(base, ev, id, iv, name, natureMod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stat other = (Stat) obj;
		return base == other.base && ev == other.ev && id == other.id && iv == other.iv && name == other.name
				&& Double.doubleToLongBits(natureMod) == Double.doubleToLongBits(other.natureMod);
	}

	@Override
	public String toString() {
		return "Stat [id=" + id + ", name=" + name + ", base=" + base + ", natureMod=" + natureMod + ", iv=" + iv
				+ ", ev=" + ev + "]";
	}

}
