package com.revature.controllers;

import com.revature.exceptions.TrainerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Party;
import com.revature.services.PartyService;
import com.revature.services.TrainerService;

@RestController
@RequestMapping("party")
public class PartyController {
	
	private PartyService ps;
	private TrainerService ts;

	public PartyController(PartyService ps, TrainerService ts) {
		super();
		this.ps = ps;
		this.ts = ts;
	}

	@GetMapping("/trainer/{id}")
	public ResponseEntity<Party> getById(@PathVariable int id) throws TrainerNotFoundException {
		return ResponseEntity.ok(ps.getPartyByTrainer(ts.getbyId(id)));
	}
	
	@PostMapping
	public ResponseEntity<Party> createStorage(@RequestBody Party party) {
		return ResponseEntity.ok(ps.saveParty(party));
	}
	
	@PutMapping
	public ResponseEntity<Party> saveStorage(@RequestBody Party party) {
		return ResponseEntity.ok(ps.saveParty(party));
	} 
}
