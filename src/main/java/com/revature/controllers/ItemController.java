package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Item;
import com.revature.services.ItemService;


@RestController
@RequestMapping("/items")
public class ItemController {

	
	private ItemService is;

	public ItemController(ItemService is) {
		super();
		this.is = is;
	}
	
	@GetMapping
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> items = is.getItems();
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Item> createItem(@RequestBody Item i) {
		return new ResponseEntity<>(is.addItem(i), HttpStatus.CREATED);
	}
}
