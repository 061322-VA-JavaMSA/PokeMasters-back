package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repositories.PokemonRepository;
import com.revature.specifications.PokemonSpecifications;

@Service
public class PokemonService {
	
	private PokemonRepository pr;

	public PokemonService(PokemonRepository pr) {
		super();
		this.pr = pr;
	}
	
	public Pokemon savePokemon(Pokemon p) {
		return pr.save(p);
	}
	
	public Pokemon getPokemonById(int id) throws PokemonNotFoundException {
		return pr.findById(id).orElseThrow(() -> new PokemonNotFoundException());
	}
	
	public List<Pokemon> getPokemonByTrainer(Trainer t) {
		return pr.findPokemonByTrainer(t);
	}
	
	public List<Pokemon> getPokemonByNo(int apiId) {
		return pr.findPokemonByApiId(apiId);
	}
	
	public List<Pokemon> getPokemonByTrade(int requestedId, int level, int range) {
		return pr.findAll(PokemonSpecifications.matchesApiId(requestedId).and(PokemonSpecifications.meetsLevelRequirements(level, range)));
	}

	public List<Pokemon> getPokemon() {
		return pr.findAll();
	}
}
