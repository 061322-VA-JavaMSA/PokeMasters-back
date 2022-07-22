package com.revature.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.revature.exceptions.PokemonNotFoundException;
import com.revature.models.Nature;
import com.revature.models.Pokemon;
import com.revature.models.Role;
import com.revature.models.Stat;
import com.revature.models.StatType;
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

	public Pokemon createPokemon(Pokemon p) throws JSONException, MalformedURLException, IOException {
		p.setId(-1);
		p.setExp(0);
		Trainer t = new Trainer(1, "calvin", "1234", "pokemaster1", 100, Role.TRAINER);
		p.setTrainer(t);
		p.setOt(t);
		String url = "https://pokeapi.co/api/v2/pokemon/" + p.getApiId();
		JSONObject json = new JSONObject(IOUtils.toString(new URL(url), Charset.forName("UTF-8")));
		p.setNickname(json.getString("name"));
		p.setNature(Util.randomEnum(Nature.class));
		JSONArray statsJson = json.getJSONArray("stats");
		Stat[] stats = new Stat[6];
		for (int i = 0; i < statsJson.length(); i++) {
			JSONObject stat = statsJson.getJSONObject(i);
			Stat s = new Stat();
			s.setBase(stat.getInt("base_stat"));
			StatType st;
			switch (stat.getJSONObject("stat").getString("name")) {
			case "hp":
				st = StatType.HP;
				break;
			case "attack":
				st = StatType.PA;
				break;
			case "defense":
				st = StatType.PD;
				break;
			case "special-attack":
				st = StatType.SA;
				break;
			case "special-defense":
				st = StatType.SD;
				break;
			case "speed":
				st = StatType.SP;
				break;
			default:
				st = StatType.NONE;
			}
			double mod = 1.0;
			if (p.getNature().adv().equals(st)) {
				mod = 1.1;
			}
			if (p.getNature().dis().equals(st)) {
				mod = 0.9;
			}
			s.setNatureMod(mod);
			s.setName(st);
			s.setEv(0);
			s.setIv((int) (Math.random() * 32));
			stats[i] = s;
		}
		p.setStats(stats);
		p.setShiny(Math.random() >= 0.98 ? true : false);
		p.setSpriteFront(String.format("https://www.pokencyclopedia.info/sprites/gen5/ani_black-white/ani_bw_%03d.gif", apiId));
		p.setSpriteBack(String.format("https://www.pokencyclopedia.info/sprites/gen5/ani_black-white/a-b_bw_%03d.gif", apiId));
		System.out.println(p);
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
