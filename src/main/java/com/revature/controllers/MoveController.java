package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.MoveNotFoundException;
import com.revature.models.Move;
import com.revature.services.MoveService;


@RestController
public class MoveController {

	private MoveService ms;
	
	public MoveController(MoveService ms) {
		this.ms = ms;
	}
	
	@GetMapping("/moves")
	public ResponseEntity<List<Move>> getMoves() {
		return ResponseEntity.ok().body(ms.getMoves());
	}
	
	@GetMapping("/moves/{id}")
	public ResponseEntity<Move> getMoveById(@PathVariable int id) throws MoveNotFoundException {
		return ResponseEntity.ok().body(ms.getMoveById(id));
	}
	
}
