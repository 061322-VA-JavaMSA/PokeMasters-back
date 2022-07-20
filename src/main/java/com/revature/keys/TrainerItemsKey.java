package com.revature.keys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrainerItemsKey implements Serializable{

	@Column(name="trainer_id")
	int trainerId;
	
	@Column(name="item_id")
	int itemId;

	public TrainerItemsKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerItemsKey(int trainerId, int itemId) {
		super();
		this.trainerId = trainerId;
		this.itemId = itemId;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemId, trainerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainerItemsKey other = (TrainerItemsKey) obj;
		return itemId == other.itemId && trainerId == other.trainerId;
	}

	@Override
	public String toString() {
		return "TrainerItemsKey [trainerId=" + trainerId + ", itemId=" + itemId + "]";
	}
	
	
}
