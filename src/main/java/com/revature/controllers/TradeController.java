package com.revature.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.TradeNotFoundException;
import com.revature.models.Trade;
import com.revature.services.TradeService;
import com.revature.services.TrainerService;

@RestController
@RequestMapping("/trades")
public class TradeController {

	private TradeService ts;
	private TrainerService trs;

	public TradeController(TradeService ts, TrainerService trs) {
		super();
		this.ts = ts;
		this.trs = trs;
	}
	
	@GetMapping("/trainer/{username}")
	public ResponseEntity<List<Trade>> getTrades(@PathVariable String username) {
		return ResponseEntity.ok(ts.getTradesByOwner(trs.getTrainer(username)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trade> getById(@PathVariable int id) throws TradeNotFoundException {
		return ResponseEntity.ok(ts.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<Trade> createTrade(@RequestBody Trade t) {
		return ResponseEntity.ok(ts.createTrade(t));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Trade> updateTrade(@RequestBody Trade t) {
		return ResponseEntity.ok(ts.saveTrade(t));
	}
	
	@DeleteMapping("/{id}")
	public void deleteTrade(@PathVariable Trade t) {
		ts.deleteTrade(t);
	}
}
