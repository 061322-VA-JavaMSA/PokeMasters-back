package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="moves")
public class Move {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private int num;
	/*
	@ManyToOne
	@JoinColumn(name="pokemon_id", nullable=false)
	private Pokemon pokemon;
	*/
	
	public Move() {
		super();
	}

	public Move(int id, int num) {
		super();
		this.id = id;
		this.num = num;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "Move [id=" + id + ", num=" + num + "]";
	}
	
	

}
