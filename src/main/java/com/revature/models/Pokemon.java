package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int hp;
	private List<Move> moves;
}
