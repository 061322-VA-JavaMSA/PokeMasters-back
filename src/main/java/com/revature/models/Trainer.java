package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trainers")
public class Trainer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	@Column(nullable=false)
	private String displayName;
	@Column(nullable=false)
	private List<Pokemon> party;
	@Column(nullable=true)
	private List<Pokemon> storage;
	@Column(nullable=true)
	private List<Item> inventory;
	@Column(nullable=false)
	private int money;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
