package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repositories.PokemonRepository;

@Service
public class PokemonService {
	
	private PokemonRepository pr;

	public PokemonService(PokemonRepository pr) {
		super();
		this.pr = pr;
	}
	
	public Pokemon addPokemon(Pokemon p) {
		return pr.save(p);
	}
	
	public Pokemon getPokemonById(int id) throws PokemonNotFoundException {
		return pr.findById(id).orElseThrow(() -> new PokemonNotFoundException());
	}
	
	public List<Pokemon> getPokemonByTrainer(Trainer t) {
		return pr.findPokemonByTrainer(t);
	}
	
	public List<Pokemon> getPokemonByNo(int no) {
		return pr.findPokemonByNo(no);
	}

	public List<Pokemon> getPokemon() {
		return pr.findAll();
	}
}
