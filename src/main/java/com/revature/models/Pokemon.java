package com.revature.models;

import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "api_id", nullable = false)
	private int apiId;
	@Column
	private String name;
	@Column(nullable = true)
	private String nickname;
	@ElementCollection
	@CollectionTable(name = "pokemon_sprite_mapping", joinColumns = {
			@JoinColumn(name = "pokemon_id", referencedColumnName = "id") })
	@Column(name = "sprite")
	private Map<String, String> sprite;
	@Enumerated(EnumType.STRING)
	private Nature nature;
	@Column(nullable = false)
	private int hp;
	@Column(nullable = false)
	private int level;
	@Column(nullable = false)
	private int exp;
	@ElementCollection
	@CollectionTable(name = "pokemon_stats_mapping", joinColumns = {
			@JoinColumn(name = "pokemon_id", referencedColumnName = "id") })
	@Column(name = "stats")
	private Map<String, Integer> stats;
	@ElementCollection
	@CollectionTable(name = "pokemon_base_mapping", joinColumns = {
			@JoinColumn(name = "pokemon_id", referencedColumnName = "id") })
	@Column(name = "iv")
	private Map<String, Integer> base;
	@ElementCollection
	@CollectionTable(name = "pokemon_iv_mapping", joinColumns = {
			@JoinColumn(name = "pokemon_id", referencedColumnName = "id") })
	@Column(name = "iv")
	private Map<String, Integer> iv;
	@ElementCollection
	@CollectionTable(name = "pokemon_ev_mapping", joinColumns = {
			@JoinColumn(name = "pokemon_id", referencedColumnName = "id") })
	@Column(name = "ev")
	private Map<String, Integer> ev;
	@Column(name = "base_exp")
	private int baseExp;
	private String type1;
	private String type2;
	private int weight;
	private int height;
	@Column(nullable = false)
	private boolean shiny;
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;
	@ManyToOne
	@JoinColumn(name = "ot_id")
	private Trainer ot;

	public Pokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pokemon(int apiId, int level, Trainer trainer) {
		super();
		this.apiId = apiId;
		this.level = level;
		this.trainer = trainer;
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

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Map<String, String> getSprite() {
		return sprite;
	}

	public void setSprite(Map<String, String> sprite) {
		this.sprite = sprite;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Map<String, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<String, Integer> stats) {
		this.stats = stats;
	}

	public Map<String, Integer> getBase() {
		return base;
	}

	public void setBase(Map<String, Integer> base) {
		this.base = base;
	}

	public Map<String, Integer> getIv() {
		return iv;
	}

	public void setIv(Map<String, Integer> iv) {
		this.iv = iv;
	}

	public Map<String, Integer> getEv() {
		return ev;
	}

	public void setEv(Map<String, Integer> ev) {
		this.ev = ev;
	}

	public int getBaseExp() {
		return baseExp;
	}

	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
	}

	public boolean isShiny() {
		return shiny;
	}

	public void setShiny(boolean shiny) {
		this.shiny = shiny;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Trainer getOt() {
		return ot;
	}

	public void setOt(Trainer ot) {
		this.ot = ot;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiId, base, baseExp, ev, exp, height, hp, id, iv, level, name, nature, nickname, ot, shiny,
				sprite, stats, trainer, type1, type2, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return apiId == other.apiId && Objects.equals(base, other.base) && baseExp == other.baseExp
				&& Objects.equals(ev, other.ev) && exp == other.exp && height == other.height && hp == other.hp
				&& id == other.id && Objects.equals(iv, other.iv) && level == other.level
				&& Objects.equals(name, other.name) && nature == other.nature
				&& Objects.equals(nickname, other.nickname) && Objects.equals(ot, other.ot) && shiny == other.shiny
				&& Objects.equals(sprite, other.sprite) && Objects.equals(stats, other.stats)
				&& Objects.equals(trainer, other.trainer) && Objects.equals(type1, other.type1)
				&& Objects.equals(type2, other.type2) && weight == other.weight;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", apiId=" + apiId + ", name=" + name + ", nickname=" + nickname + ", sprite="
				+ sprite + ", nature=" + nature + ", hp=" + hp + ", level=" + level + ", exp=" + exp + ", stats="
				+ stats + ", base=" + base + ", iv=" + iv + ", ev=" + ev + ", baseExp=" + baseExp + ", type1=" + type1
				+ ", type2=" + type2 + ", weight=" + weight + ", height=" + height + ", shiny=" + shiny + ", trainer="
				+ trainer + ", ot=" + ot + "]";
	}

}
