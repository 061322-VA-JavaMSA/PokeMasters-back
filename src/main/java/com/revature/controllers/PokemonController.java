package com.revature.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.models.Trade;
import com.revature.services.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	private PokemonService ps;

	public PokemonController(PokemonService ps) {
		super();
		this.ps = ps;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> getById(@PathParam("id") int id) throws PokemonNotFoundException {
		return new ResponseEntity<>(ps.getPokemonById(id), HttpStatus.OK);
	}
	
	@GetMapping("/trade/{id}")
	public ResponseEntity<List<Pokemon>> getByTrade(@RequestBody Trade t) {
//		return new ResponseEntity<>(ps.)
		return null;
	}
}
