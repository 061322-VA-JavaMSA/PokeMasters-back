package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.keys.TrainerItemsKey;
import com.revature.models.Item;
import com.revature.models.Trainer;
import com.revature.models.TrainerItem;
import com.revature.services.ItemService;
import com.revature.services.TrainerItemService;
import com.revature.services.TrainerService;

@RestController
@RequestMapping("/trainer-items")
public class TrainerItemController {

	private TrainerItemService tis;
	private TrainerService ts;
	private ItemService is;

	public TrainerItemController(TrainerItemService tis, TrainerService ts, ItemService is) {
		super();
		this.tis = tis;
		this.ts = ts;
		this.is = is;
	}
	
	@GetMapping
	public ResponseEntity<List<TrainerItem>> getTrainerItems() {
		List<TrainerItem> ti = tis.getItems();
		
		return new ResponseEntity<>(ti, HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<TrainerItem> postTrainerItemsByTrainer(@RequestBody TrainerItemsKey tik) {
		TrainerItem tItem = tis.getByTrainer(tik);
		if(tItem == null) {
			Item i = is.getById(tik.getItemId());
			Trainer t = ts.getbyId(tik.getTrainerId());
			tItem = new TrainerItem(new TrainerItemsKey(tik.getTrainerId(), tik.getItemId()), t, i, 1);
			tis.saveTrainerItem(tItem);
			
		}
		return new ResponseEntity<>(tItem, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<TrainerItem>> getTrainerItems(@PathVariable int id) {
		List<TrainerItem> tItems = tis.getTrainerItems(id);
		
		return new ResponseEntity<>(tItems, HttpStatus.OK);
	}
}
