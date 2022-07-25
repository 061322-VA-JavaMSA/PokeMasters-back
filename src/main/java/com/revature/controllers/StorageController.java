package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Storage;
import com.revature.services.StorageService;

@RestController("/storage")
@ResponseBody
public class StorageController {
	
	private StorageService ss;
	
	public StorageController(StorageService ss) {
		super();
		this.ss = ss;
	}

	@GetMapping("/trainer/{username}")
	public ResponseEntity<Storage> getTrainerStorage(@PathVariable String username) {
		return new ResponseEntity<>(ss.getStorageByUsername(username), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Storage> saveStorage(@RequestBody Storage s) {
		return new ResponseEntity<>(ss.saveStorage(s), HttpStatus.OK);
	}
}
