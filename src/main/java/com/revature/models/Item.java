package com.revature.models;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="api_id", nullable=false)
	private int apiId;
	@Column(name="item_name", nullable=false)
	private String itemName;
	@Column(name="price", nullable=false)
	private int price;
	@Column(name="effect", nullable= false)
	private String effect;
	@Column(name="type", nullable=false)
	private String type;
	@OneToMany(mappedBy = "item")
	Set<TrainerItem> qty;
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int id, int apiId, String itemName, int price, String effect, String type) {
		super();
		this.id = id;
		this.apiId = apiId;
		this.itemName = itemName;
		this.price = price;
		this.effect = effect;
		this.type = type;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
		return Objects.hash(apiId, effect, id, itemName, price, type);
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
		return apiId == other.apiId && Objects.equals(effect, other.effect) && id == other.id
				&& Objects.equals(itemName, other.itemName) && price == other.price && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", apiId=" + apiId + ", itemName=" + itemName + ", price=" + price + ", effect="
				+ effect + ", type=" + type + "]";
	}
	
	
	
}
