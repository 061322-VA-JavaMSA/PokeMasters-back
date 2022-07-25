package com.revature.models;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String displayName;
	@Column(nullable = false)
	private int money;
	@OrderColumn
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "trainer_id")
	private List<Pokemon> party;
	@Enumerated(EnumType.STRING)
	private Role role;
	@OneToMany(mappedBy = "trainer")
	Set<TrainerItem> qty;
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(int id, String username, String password, String displayName, int money, List<Pokemon> party, Role role, Set<TrainerItem> qty) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.money = money;
		this.party = party;
		this.role = role;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public List<Pokemon> getParty() {
		return party;
	}
	public void setParty(List<Pokemon> party) {
		this.party = party;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<TrainerItem> getQty() {
		return qty;
	}
	public void setQty(Set<TrainerItem> qty) {
		this.qty = qty;
	}
	@Override
	public int hashCode() {
		return Objects.hash(displayName, id, money, party, password, qty, role, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainer other = (Trainer) obj;
		return Objects.equals(displayName, other.displayName) && id == other.id && money == other.money
				&& Objects.equals(party, other.party) && Objects.equals(password, other.password)
				&& Objects.equals(qty, other.qty) && role == other.role && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "Trainer [id=" + id + ", username=" + username + ", password=" + password + ", displayName="
				+ displayName + ", money=" + money + ", party=" + party + ", role=" + role + ", qty=" + qty + "]";
	}

	
}
