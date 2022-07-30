package com.revature.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.dros.PokemonDRO;
import com.revature.exceptions.PokemonNotFoundException;
import com.revature.exceptions.StorageFullException;
import com.revature.models.Nature;
import com.revature.models.Party;
import com.revature.models.Pokemon;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.repositories.PokemonRepository;
import com.revature.specifications.PokemonSpecifications;
import com.revature.util.Util;

@Service
public class PokemonService {

	private PokemonRepository pr;
	private PartyService ps;
	private StorageService ss;
	private RestTemplate rt;

	public PokemonService(PokemonRepository pr, PartyService ps, StorageService ss, RestTemplate rt) {
		super();
		this.pr = pr;
		this.ps = ps;
		this.ss = ss;
		this.rt = rt;
	}

	public Pokemon savePokemon(Pokemon p) {
		return pr.save(p);
	}

	public Pokemon createPokemon(Pokemon p) throws StorageFullException {
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("user-agent", "Application");
//		HttpEntity<String> entity = new HttpEntity<>(headers);
//		String endpoint = "https://pokeapi.co/api/v2/pokemon/" + p.getApiId();
		p.setId(-1);
		p.setShiny(Math.random() >= 0.98 ? true : false);
		PokemonDRO pd = rt.getForObject("https://pokeapi.co/api/v2/pokemon/" + p.getApiId(), PokemonDRO.class);
//		PokemonDRO pd = rt.exchange(endpoint, HttpMethod.GET, entity,PokemonDRO.class).getBody();
		p.setName(pd.getName());
		p.setBaseExp(pd.getBaseExp());
		p.setExp(0);
		p.setBase(pd.getStats());
		Map<String, String> sprites = new HashMap<>();
		sprites.put("front", pd.getSprites().get(p.isShiny() ? "front_shiny" : "front_default").toString());
		sprites.put("back", pd.getSprites().get(p.isShiny() ? "back_shiny" : "back_default").toString());
		Map ani = (Map) pd.getSprites().get("animated");
		sprites.put("front_a", ani.get(p.isShiny() ? "front_shiny" : "front_default").toString());
		sprites.put("back_a", ani.get(p.isShiny() ? "back_shiny" : "back_default").toString());
		p.setSprite(sprites);
		String[] values = {"hp", "att", "def", "satt", "sdef", "speed"};
		Map<String, Integer> iv = new HashMap<>();
		Map<String, Integer> ev = new HashMap<>();
		for (String v : values) {
			iv.put(v, (int)(Math.random() * 32));
			ev.put(v, 0);
		}
		p.setIv(iv);
		p.setEv(ev);
		p.setType1(pd.getType1());
		p.setType2(pd.getType2());
		p.setWeight(pd.getWeight());
		p.setHeight(pd.getHeight());
		p.setNature(Util.randomEnum(Nature.class));
		p.setStats(getStats(p.getBase(), p.getIv(), p.getEv(), p.getLevel(), p.getNature()));
		p.setHp(p.getStats().get("hp"));
		p.setOt(p.getTrainer());
		
		Pokemon saved = pr.save(p);
		Party party = ps.getPartyByTrainer(saved.getTrainer());
		
		if (party.getPokemon().size() < 6) {
			party.getPokemon().add(saved);
			ps.saveParty(party);
		} else {
			Storage storage = ss.getStorageByTrainer(saved.getTrainer());
			storage.insert(saved);
			ss.saveStorage(storage);
		}
		return saved;
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
	
	private Map<String, Integer> getStats(Map<String, Integer> b, Map<String, Integer> i, Map<String, Integer> e, int l, Nature n) {
		String[] values = {"hp", "att", "def", "satt", "sdef", "speed"};
		Map<String, Integer> s = new HashMap<>();
		for (String v : values) {
			double stat = 0;
			if (v.equals("hp")) {
				stat = Math.floor(0.01 * (2 * b.get(v) + i.get(v) + Math.floor(e.get(v) * 0.25)) * l) + l + 10;
			} else {
				stat = (Math.floor(0.01 * (2 * b.get(v) + i.get(v) + Math.floor(e.get(v) * 0.25)) * l) + 5) * n.mod(v);
			}
			s.put(v, (int) stat);
		}
		return s;
	}
}
