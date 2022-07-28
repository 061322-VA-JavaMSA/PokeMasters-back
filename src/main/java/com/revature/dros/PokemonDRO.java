package com.revature.dros;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonDRO {

	private int id;
	@JsonProperty("base_experience")
	private int baseExp;
	private Map stats;
	private String type1;
	private String type2;
	private int height;
	private int weight;
	private String name;
	private Map sprites;

	public PokemonDRO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExperience) {
		this.baseExp = baseExperience;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Map getStats() {
		return stats;
	}

	public void setStats(Map stats) {
		this.stats = stats;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map getSprites() {
		return sprites;
	}

	public void setSprites(Map sprites) {
		this.sprites = sprites;
	}

	@Override
	public int hashCode() {
		return Objects.hash(baseExp, height, id, name, sprites, stats, type1, type2, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonDRO other = (PokemonDRO) obj;
		return baseExp == other.baseExp && height == other.height && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(sprites, other.sprites) && Objects.equals(stats, other.stats)
				&& Objects.equals(type1, other.type1) && Objects.equals(type2, other.type2) && weight == other.weight;
	}

	@Override
	public String toString() {
		return "PokemonDRO [id=" + id + ", baseExp=" + baseExp + ", stats=" + stats + ", type1=" + type1 + ", type2="
				+ type2 + ", height=" + height + ", weight=" + weight + ", name=" + name + ", sprites=" + sprites + "]";
	}

	@JsonProperty("sprites")
	private void unpackSprites(Map sprites) {
		Map versions = (Map) sprites.get("versions");
		Map gen = (Map) versions.get("generation-v");
		this.sprites = (Map) gen.get("black-white");

	}

	@JsonProperty("stats")
	private void unpackStats(Map[] stats) {
		this.stats = new HashMap();
		for (Map m : stats) {
			Map s = (Map) m.get("stat");
			this.stats.put(s.get("name").toString().replace("special-attack", "satt").replace("special-defense", "sdef")
					.replace("defense", "def").replace("attack", "att"), m.get("base_stat"));
		}
	}

	@JsonProperty("types")
	private void unpackTypes(Map[] types) {
		Map map = (Map) types[0].get("type");
		type1 = map.get("name").toString();
		if (types.length == 2) {
			map = (Map) types[1].get("type");
			type2 = map.get("name").toString();
		} else {
			type2 = "";
		}
	}

}
