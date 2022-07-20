package com.revature.models;

import java.util.Objects;

import javax.persistence.*;

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
	@Column(nullable = false)
	private int hp;
	@Column(nullable = false)
	private int attack;
	@Column(nullable = false)
	private int defense;
	@Column(name = "s_attack", nullable = false)
	private int sAttack;
	@Column(name = "s_defense", nullable = false)
	private int sDefense;
	@Column(nullable = false)
	private int speed;
	@Column(nullable = false)
	private int exp;
	@Column(nullable = false)
	private int level;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getsAttack() {
		return sAttack;
	}

	public void setsAttack(int sAttack) {
		this.sAttack = sAttack;
	}

	public int getsDefense() {
		return sDefense;
	}

	public void setsDefense(int sDefense) {
		this.sDefense = sDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
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
		return Objects.hash(apiId, attack, defense, exp, hp, id, level, nickname, ot, sAttack, sDefense, speed,
				trainer);
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
		return apiId == other.apiId && attack == other.attack && defense == other.defense && exp == other.exp
				&& hp == other.hp && id == other.id && level == other.level && Objects.equals(nickname, other.nickname)
				&& Objects.equals(ot, other.ot) && sAttack == other.sAttack && sDefense == other.sDefense
				&& speed == other.speed && Objects.equals(trainer, other.trainer);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", apiId=" + apiId + ", nickname=" + nickname + ", hp=" + hp + ", attack=" + attack
				+ ", defense=" + defense + ", sAttack=" + sAttack + ", sDefense=" + sDefense + ", speed=" + speed
				+ ", exp=" + exp + ", level=" + level + ", trainer=" + trainer + ", ot=" + ot + "]";
	}

}
