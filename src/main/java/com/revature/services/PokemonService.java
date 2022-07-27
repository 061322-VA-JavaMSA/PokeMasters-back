package com.revature.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Nature;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;
import com.revature.repositories.PokemonRepository;
import com.revature.specifications.PokemonSpecifications;
import com.revature.util.Util;

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

	public Pokemon createPokemon(Pokemon p) {
		p.setId(-1);
		Map<String, Integer> iv = new HashMap<>();
		iv.put("hp", (int)(Math.random() * 32));
		iv.put("att", (int)(Math.random() * 32));
		iv.put("def", (int)(Math.random() * 32));
		iv.put("satt", (int)(Math.random() * 32));
		iv.put("sdef", (int)(Math.random() * 32));
		iv.put("speed", (int)(Math.random() * 32));
		p.setIv(iv);
		Map<String, Integer> ev = new HashMap<>();
		ev.put("hp", (int)(Math.random() * 32));
		ev.put("att", (int)(Math.random() * 32));
		ev.put("def", (int)(Math.random() * 32));
		ev.put("satt", (int)(Math.random() * 32));
		ev.put("sdef", (int)(Math.random() * 32));
		ev.put("speed", (int)(Math.random() * 32));
		p.setEv(ev);
		p.setShiny(Math.random() >= 0.98 ? true : false);
		p.setNature(Util.randomEnum(Nature.class));
		p.setOt(p.getTrainer());
		
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
		return pr.findAll(PokemonSpecifications.matchesApiId(requestedId)
				.and(PokemonSpecifications.meetsLevelRequirements(level, range)));
	}

	public List<Pokemon> getPokemon() {
		return pr.findAll();
	}
}
