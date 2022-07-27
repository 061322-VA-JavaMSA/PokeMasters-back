package com.revature.models;

import java.util.Map;
import java.util.Objects;

import javax.persistence.CascadeType;
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
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "api_id", nullable = false)
	private int apiId;
	@Column(nullable = true)
	private String nickname;
	@Enumerated(EnumType.STRING)
	private Nature nature;
	@Column(nullable = false)
	private int hp;
	@Column(nullable = false)
	private int level;
	@Column(nullable = false)
	private int exp;
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

	public int getApiId() {
		return apiId;
	}

	public void setApiId(int apiId) {
		this.apiId = apiId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return Objects.hash(apiId, ev, exp, hp, id, iv, level, nature, nickname, ot, shiny, trainer);
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
		return apiId == other.apiId && Objects.equals(ev, other.ev) && exp == other.exp && hp == other.hp
				&& id == other.id && Objects.equals(iv, other.iv) && level == other.level && nature == other.nature
				&& Objects.equals(nickname, other.nickname) && Objects.equals(ot, other.ot) && shiny == other.shiny
				&& Objects.equals(trainer, other.trainer);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", apiId=" + apiId + ", nickname=" + nickname + ", nature=" + nature + ", hp=" + hp
				+ ", level=" + level + ", exp=" + exp + ", iv=" + iv + ", ev=" + ev + ", shiny=" + shiny + ", trainer="
				+ trainer + ", ot=" + ot + "]";
	}

}
