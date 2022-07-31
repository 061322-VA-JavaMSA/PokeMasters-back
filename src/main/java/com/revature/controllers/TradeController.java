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

import com.revature.exceptions.StorageFullException;
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
	
	@GetMapping("/trainer/{id}")
	public ResponseEntity<List<Trade>> getOwnedTrades(@PathVariable int id) {
		return ResponseEntity.ok(ts.getOwnedTrades(trs.getbyId(id)));
	}
	
	@GetMapping("/trainer/!{id}")
	public ResponseEntity<List<Trade>> getAvailableTrades(@PathVariable int id) {
		return ResponseEntity.ok(ts.getAvailableTrades(trs.getbyId(id)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trade> getById(@PathVariable int id) throws TradeNotFoundException {
		return ResponseEntity.ok(ts.getById(id));
	}
	
	@PostMapping("/trainer/{id}")
	public ResponseEntity<Trade> createTrade(@RequestBody Trade t, @PathVariable int id) {
		t.setOwner(trs.getbyId(id));
		return ResponseEntity.ok(ts.createTrade(t));
	}
	
	@PutMapping
	public ResponseEntity<Trade> updateTrade(@RequestBody Trade t) throws StorageFullException {
		return ResponseEntity.ok(ts.updateTrade(t));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTrade(@PathVariable int id) throws StorageFullException, TradeNotFoundException {
		return ts.deleteTrade(ts.getById(id));
	}
}
