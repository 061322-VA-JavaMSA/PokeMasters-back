package com.revature.controllers;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
		return new ResponseEntity<>(ps.getPokemon(), HttpStatus.OK);
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
