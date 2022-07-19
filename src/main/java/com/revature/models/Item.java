package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="api_id", nullable=false)
	private int apiId;
	@Column(name="price", nullable=false)
	private int price;
	@Column(name="effect", nullable= false)
	private String effect;
	@Column(name="type", nullable=false)
	private String type;
	
	public Item() {
		super();

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apiId, effect, id, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return apiId == other.apiId && Objects.equals(effect, other.effect) && id == other.id && price == other.price
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", apiId=" + apiId + ", price=" + price + ", effect=" + effect + ", type=" + type
				+ "]";
	}
	
	
	
}
