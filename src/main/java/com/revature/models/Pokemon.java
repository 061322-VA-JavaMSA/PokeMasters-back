package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private int no;
	@Column(nullable = true)
	private String nickname;
	@Column(nullable = false)
	private int hp;
	@Column(nullable = false)
	private int attack;
	@Column(nullable = false)
	private int defense;
	@Column(nullable = false)
	private int sAttack;
	@Column(nullable = false)
	private int sDefense;
	@Column(nullable = false)
	private int speed;
	@Column(nullable = false)
	private int exp;
	@Column(nullable = false)
	private int level;
	@ManyToOne
	@Column(name = "trainer_id")
	private Trainer trainer;

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

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	@Override
	public int hashCode() {
		return Objects.hash(attack, defense, exp, hp, id, level, nickname, no, sAttack, sDefense, speed, trainer);
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
		return attack == other.attack && defense == other.defense && exp == other.exp && hp == other.hp
				&& id == other.id && level == other.level && Objects.equals(nickname, other.nickname) && no == other.no
				&& sAttack == other.sAttack && sDefense == other.sDefense && speed == other.speed
				&& Objects.equals(trainer, other.trainer);
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", no=" + no + ", nickname=" + nickname + ", hp=" + hp + ", attack=" + attack
				+ ", defense=" + defense + ", sAttack=" + sAttack + ", sDefense=" + sDefense + ", speed=" + speed
				+ ", exp=" + exp + ", level=" + level + ", trainer=" + trainer + "]";
	}

}
