package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "api_id", nullable = false)
	private int apiId;
	private String spriteFront;
	private String spriteBack;
	@Column(nullable = true)
	private String nickname;
	@Enumerated(EnumType.STRING)
	private Nature nature;
	@Column(nullable = false)
	private int level;
	@Column(nullable = false)
	private int exp;
	@Column(nullable = false)
	private int baseExp;
	@OrderColumn
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="pokemon_id")
	private Stat[] stats;
	@Column(nullable=false)
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
	public String getSpriteFront() {
		return spriteFront;
	}
	public void setSpriteFront(String spriteFront) {
		this.spriteFront = spriteFront;
	}
	public String getSpriteBack() {
		return spriteBack;
	}
	public void setSpriteBack(String spriteBack) {
		this.spriteBack = spriteBack;
	}
	public int getBaseExp() {
		return baseExp;
	}
	public void setBaseExp(int baseExp) {
		this.baseExp = baseExp;
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
	public Stat[] getStats() {
		return stats;
	}
	public void setStats(Stat[] stats) {
		this.stats = stats;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(stats);
		result = prime * result + Objects.hash(apiId, baseExp, exp, id, level, nature, nickname, ot, shiny, spriteBack,
				spriteFront, trainer);
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
		Pokemon other = (Pokemon) obj;
		return apiId == other.apiId && baseExp == other.baseExp && exp == other.exp && id == other.id
				&& level == other.level && nature == other.nature && Objects.equals(nickname, other.nickname)
				&& Objects.equals(ot, other.ot) && shiny == other.shiny && Objects.equals(spriteBack, other.spriteBack)
				&& Objects.equals(spriteFront, other.spriteFront) && Arrays.equals(stats, other.stats)
				&& Objects.equals(trainer, other.trainer);
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", apiId=" + apiId + ", spriteFront=" + spriteFront + ", spriteBack=" + spriteBack
				+ ", nickname=" + nickname + ", nature=" + nature + ", level=" + level + ", exp=" + exp + ", baseExp="
				+ baseExp + ", stats=" + Arrays.toString(stats) + ", shiny=" + shiny + ", trainer=" + trainer + ", ot="
				+ ot + "]";
	}
	
	
}
