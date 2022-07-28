package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Box;
import com.revature.services.BoxService;

@RestController
@RequestMapping("/box")
public class BoxController {

	private BoxService bs;

	public BoxController(BoxService bs) {
		super();
		this.bs = bs;
	}
	
	@PutMapping
	public ResponseEntity<Box> saveBox(@RequestBody Box b) {
		return ResponseEntity.ok(bs.saveBox(b));
	}
}
