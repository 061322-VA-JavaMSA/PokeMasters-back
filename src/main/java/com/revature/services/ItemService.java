package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.Item;
import com.revature.repositories.ItemRepository;



@Service
public class ItemService {

	private ItemRepository ir;

	public ItemService(ItemRepository ir) {
		super();
		this.ir = ir;
	}
	
	
	public List<Item> getItems() {
		return ir.findAll();
	}
	
	public Item getItemById(int id) throws ItemNotFoundException{
		Item item = ir.findById(id).orElseThrow(() -> new ItemNotFoundException());
		return item;
	}
	
	public Item addItem(Item item) {
		return ir.save(item);
	}
	
	public Item updateItem(Item item) {
		return ir.save(item);
	}
	
	public void deleteItem(int id) {
		ir.deleteById(id);
	}

	public Item getById(int id) {
		Optional<Item> i = ir.findById(id);
		Item item = i.get();
		return item;
		
	}
}
