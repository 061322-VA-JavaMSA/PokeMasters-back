package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evs")
public class EV {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private int hp;
	@Column(nullable=false)
	private int att;
	@Column(nullable=false)
	private int def;
	@Column(nullable=false)
	private int satt;
	@Column(nullable=false)
	private int sdef;
	@Column(nullable=false)
	private int speed;
	public EV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getSatt() {
		return satt;
	}
	public void setSatt(int satt) {
		this.satt = satt;
	}
	public int getSdef() {
		return sdef;
	}
	public void setSdef(int sdef) {
		this.sdef = sdef;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	@Override
	public int hashCode() {
		return Objects.hash(att, def, hp, id, satt, sdef, speed);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EV other = (EV) obj;
		return att == other.att && def == other.def && hp == other.hp && id == other.id && satt == other.satt
				&& sdef == other.sdef && speed == other.speed;
	}
	@Override
	public String toString() {
		return "EV [id=" + id + ", hp=" + hp + ", att=" + att + ", def=" + def + ", satt=" + satt + ", sdef=" + sdef
				+ ", speed=" + speed + "]";
	}
	
	
}
