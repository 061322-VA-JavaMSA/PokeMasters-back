package com.revature.models;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.revature.keys.TrainerItemsKey;

@Entity
public class TrainerItem {

	@EmbeddedId
	TrainerItemsKey id; 
	
	@ManyToOne
	@MapsId("trainerId")
	@JoinColumn(name="trainer_id")
	@JsonBackReference
	Trainer trainer; 
	
	@ManyToOne
	@MapsId("itemId")
	@JoinColumn(name="item_id")
	Item item;
	
	int qty;

	public TrainerItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerItem(TrainerItemsKey id, Trainer trainer, Item item, int qty) {
		super();
		this.id = id;
		this.trainer = trainer;
		this.item = item;
		this.qty = qty;
	}

	public TrainerItemsKey getId() {
		return id;
	}

	public void setId(TrainerItemsKey id) {
		this.id = id;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, item, qty, trainer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerItem other = (TrainerItem) obj;
		return Objects.equals(id, other.id) && Objects.equals(item, other.item) && qty == other.qty
				&& Objects.equals(trainer, other.trainer);
	}

	@Override
	public String toString() {
		return "TrainerItem [id=" + id + ", trainer=" + trainer + ", item=" + item + ", qty=" + qty + "]";
	}
	
	
	
}
