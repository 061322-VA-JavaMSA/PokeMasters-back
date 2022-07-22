package com.revature.dtos;

import java.util.Arrays;
import java.util.Objects;

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


	public PokemonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getApiId() {
		return apiId;
	}


	public void setApiId(int apiId) {
		this.apiId = apiId;
	}


	public String getSpriteFront() {
		return spriteFront;
	}


	public void setSpriteFront(String spriteFront) {
		this.spriteFront = spriteFront;
	}


	public String getSpriteBack() {
		return spriteBack;
	}


	public void setSpriteBack(String spriteBack) {
		this.spriteBack = spriteBack;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public Nature getNature() {
		return nature;
	}


	public void setNature(Nature nature) {
		this.nature = nature;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public StatDTO[] getStats() {
		return stats;
	}


	public void setStats(StatDTO[] stats) {
		this.stats = stats;
	}


	public boolean isShiny() {
		return shiny;
	}


	public void setShiny(boolean shiny) {
		this.shiny = shiny;
	}


	public Trainer getTrainer() {
		return trainer;
	}


	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}


	public Trainer getOt() {
		return ot;
	}


	public void setOt(Trainer ot) {
		this.ot = ot;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(stats);
		result = prime * result
				+ Objects.hash(apiId, id, level, nature, nickname, ot, shiny, spriteBack, spriteFront, trainer);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonDTO other = (PokemonDTO) obj;
		return apiId == other.apiId && id == other.id && level == other.level && nature == other.nature
				&& Objects.equals(nickname, other.nickname) && Objects.equals(ot, other.ot) && shiny == other.shiny
				&& Objects.equals(spriteBack, other.spriteBack) && Objects.equals(spriteFront, other.spriteFront)
				&& Arrays.equals(stats, other.stats) && Objects.equals(trainer, other.trainer);
	}


	@Override
	public String toString() {
		return "PokemonDTO [id=" + id + ", apiId=" + apiId + ", spriteFront=" + spriteFront + ", spriteBack="
				+ spriteBack + ", nickname=" + nickname + ", nature=" + nature + ", level=" + level + ", stats="
				+ Arrays.toString(stats) + ", shiny=" + shiny + ", trainer=" + trainer + ", ot=" + ot + "]";
	}
	
	
}
