package com.revature.models;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="storage")
public class Storage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OrderColumn
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="storage_id")
	private Box[] boxes;
	@Column(nullable=false)
	private int activeIndex;
	@OneToOne
	@JoinColumn(name="trainer")
	private Trainer trainer;
	public Storage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Box[] getBoxes() {
		return boxes;
	}
	public void setBoxes(Box[] boxes) {
		this.boxes = boxes;
	}
	public int getActiveIndex() {
		return activeIndex;
	}
	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(boxes);
		result = prime * result + Objects.hash(activeIndex, id);
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
		Storage other = (Storage) obj;
		return activeIndex == other.activeIndex && Arrays.equals(boxes, other.boxes) && id == other.id;
	}
	@Override
	public String toString() {
		return "Storage [id=" + id + ", boxes=" + Arrays.toString(boxes) + ", activeIndex=" + activeIndex + "]";
	}
	
	
}
