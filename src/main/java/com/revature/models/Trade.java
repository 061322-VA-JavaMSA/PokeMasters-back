package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trades")
public class Trade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne
	@JoinColumn(name="pokemon_listed_id", insertable = true, updatable = false)
	private Pokemon listed;
	@OneToOne
	@JoinColumn(name="pokemon_offered_id", insertable = false, updatable = true)
	private Pokemon offered;
	@Column(name = "requested_id", nullable = false)
	private int requestedId;
	@Column(nullable = false)
	private int range;
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer owner;

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pokemon getListed() {
		return listed;
	}

	public void setListed(Pokemon listed) {
		this.listed = listed;
	}

	public Pokemon getOffered() {
		return offered;
	}

	public void setOffered(Pokemon offered) {
		this.offered = offered;
	}

	public int getRequestedId() {
		return requestedId;
	}

	public void setRequestedId(int requestedId) {
		this.requestedId = requestedId;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, listed, offered, range, requestedId, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		return id == other.id && Objects.equals(listed, other.listed) && Objects.equals(offered, other.offered)
				&& range == other.range && requestedId == other.requestedId && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", status=" + status + ", listed=" + listed + ", offered=" + offered
				+ ", requestedId=" + requestedId + ", range=" + range + "]";
	}

}
