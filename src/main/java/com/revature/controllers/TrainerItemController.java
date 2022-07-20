package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.TrainerItem;
import com.revature.services.TrainerItemService;

@RestController
@RequestMapping("/trainer-items")
public class TrainerItemController {

	private TrainerItemService tis;

	public TrainerItemController(TrainerItemService tis) {
		super();
		this.tis = tis;
	}
	
	@GetMapping
	public ResponseEntity<List<TrainerItem>> getTrainerItems() {
		List<TrainerItem> ti = tis.getItems();
		
		return new ResponseEntity<>(ti, HttpStatus.OK);
	}
}
