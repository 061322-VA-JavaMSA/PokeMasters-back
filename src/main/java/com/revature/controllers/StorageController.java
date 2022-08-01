package com.revature.controllers;

import com.revature.exceptions.TrainerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.StorageNotFoundException;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.services.StorageService;
import com.revature.services.TrainerService;

@RestController
@RequestMapping(("/storage"))
public class StorageController {
	
	private StorageService ss;
	private TrainerService ts;
	
	public StorageController(StorageService ss, TrainerService ts) {
		super();
		this.ss = ss;
		this.ts = ts;
	}

	@GetMapping("/trainer/{id}")
	public ResponseEntity<Storage> getTrainerStorage(@PathVariable int id) throws TrainerNotFoundException {
		Trainer t = ts.getbyId(id);
		return new ResponseEntity<>(ss.getStorageByTrainer(t), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Storage> getById(@PathVariable int id) throws StorageNotFoundException {
		return ResponseEntity.ok(ss.getStorageById(id));
	}
	
	@PostMapping
	public ResponseEntity<Storage> createStorage(@RequestBody Storage s) {
		return new ResponseEntity<>(ss.createStorage(s), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Storage> saveStorage(@RequestBody Storage s) {
		return new ResponseEntity<>(ss.saveStorage(s), HttpStatus.OK);
	}
}
