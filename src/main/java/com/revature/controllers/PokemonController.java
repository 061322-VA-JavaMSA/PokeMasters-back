package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

@Controller
public class PokemonController {

	private PokemonService ps;
	private ObjectMapper om;

	public PokemonController(PokemonService ps, ObjectMapper om) {
		super();
		this.ps = ps;
		this.om = om;
	}
	
	@GetMapping(
			value="/pokemon",
			produces="application/json")
	@ResponseBody
	public String getPokemonAsJson() {
		List<Pokemon> pokemon = ps.getPokemon();
		try {
			return om.writeValueAsString(pokemon);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	@GetMapping(
			value="/pokemon/{id}",
			produces="application/json")
	public String getPokemonWithId(@PathVariable int id) {
		try {
			Pokemon p = ps.getPokemonById(id);
			return om.writeValueAsString(p);
		} catch (PokemonNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return String.format("Pokemon of id=%s was not found.", id);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	@PostMapping(
			value="/pokemon",
			produces="application/json",
			consumes= {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<String> addPokemon(Model model) {
		Pokemon p = (Pokemon) model.getAttribute(getPokemonAsJson());
		p = ps.addPokemon(p);
		try {
			return new ResponseEntity<String>(om.writeValueAsString(p), HttpStatus.ACCEPTED);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Failed to add Pokemon", HttpStatus.BAD_REQUEST);
		}
	}
	
}
