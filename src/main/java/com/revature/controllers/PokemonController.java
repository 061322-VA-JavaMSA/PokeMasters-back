package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	private PokemonService ps;

	public PokemonController(PokemonService ps) {
		super();
		this.ps = ps;
	}
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAll() {
		return new ResponseEntity<>(ps.getPokemon(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getById(@PathVariable int id) throws PokemonNotFoundException {
		return new ResponseEntity<>(ps.getPokemonById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon p) {
		p.setId(-1);
		return new ResponseEntity<>(ps.savePokemon(p), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon p) {
		return new ResponseEntity<>(ps.savePokemon(p), HttpStatus.ACCEPTED);
	}
}
