package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Stat;
import com.revature.models.StatType;

public class StatDTO {

	private int id;
	private StatType name;
	private int stat;
	
	public StatDTO(Stat stat, int level) {
		this.id = stat.getId();
		this.name = stat.getName();
		this.stat = calculate(stat, level);
	}
	
	private int calculate(Stat stat, int level) {
		double n = stat.getNatureMod();
		int b = stat.getBase();
		int i = stat.getIv();
		int e = stat.getEv();
		int l = level;
		int calc = ((2 * b + i + (e/4)) * l)/100;
		switch (name) {
		case HP:
			calc += l + 10;
			break;
			default:
				calc += 5;
				calc = (int)((double) calc * n);
		}
		
		return calc;
	}

	@Override
	public String toString() {
		return "StatDTO [id=" + id + ", name=" + name + ", stat=" + stat + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, stat);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatDTO other = (StatDTO) obj;
		return id == other.id && name == other.name && stat == other.stat;
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

	public int getStat() {
		return stat;
	}

	public void setStat(int stat) {
		this.stat = stat;
	}

	public StatDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}
