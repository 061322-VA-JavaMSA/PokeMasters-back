package com.revature.dtos;

import com.revature.models.Nature;
import com.revature.models.Pokemon;
import com.revature.models.Trainer;

public class PokemonDTO {

	private int id;
	private int apiId;
	private String spriteFront;
	private String spriteBack;
	private String nickname;
	private Nature nature;
	private int level;
	private StatDTO[] stats;
	private boolean shiny;
	private Trainer trainer;
	private Trainer ot;
	
	
	public PokemonDTO(Pokemon p) {
		id = p.getId();
		apiId = p.getApiId();
		spriteFront = p.getSpriteFront();
		spriteBack = p.getSpriteBack();
		nickname = p.getNickname();
		nature = p.getNature();
		level = p.getLevel();
		stats = new StatDTO[p.getStats().length];
		for(int i=0; i<p.getStats().length; i++) {
			stats[i] = new StatDTO(p.getStats()[i], p.getLevel());
		}
		shiny = p.isShiny();
		trainer = p.getTrainer();
		ot = p.getOt();
	}
}
