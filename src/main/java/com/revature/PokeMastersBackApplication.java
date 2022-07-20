package com.revature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.revature.keys.TrainerItemsKey;
import com.revature.models.Item;
import com.revature.models.Move;
import com.revature.models.Pokemon;
import com.revature.models.Role;
import com.revature.models.Trainer;
import com.revature.models.TrainerItem;
import com.revature.services.ItemService;
import com.revature.services.MoveService;
import com.revature.services.PokemonService;
import com.revature.services.TrainerItemService;
import com.revature.services.TrainerService;

@SpringBootApplication
public class PokeMastersBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMastersBackApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TrainerService ts, MoveService ms, PokemonService ps, ItemService is, TrainerItemService tis) {
		return args -> {
			Trainer t1 = ts.saveTrainer(new Trainer(-1, "calvin", "1234", "pokemaster1", 100, Role.TRAINER));
			Trainer t2 = ts.saveTrainer(new Trainer(-1, "elonmusk", "1234", "pokemaster", 100, Role.TRAINER));
			ts.saveTrainer(new Trainer(-1, "adam", "1234", "pokemaster2", 100, Role.ADMIN));
			ts.saveTrainer(new Trainer(-1, "kevin", "1234", "pokemaster3", 100, Role.TRAINER));
			ms.saveMove(new Move(-1, 3));
			ps.savePokemon(new Pokemon(-1, 4, "Charmander", 39, 45, 50, 48, 48, 65, 0, 5, t1, t1));
			ps.savePokemon(new Pokemon(-1, 1, "Bulbasaur", 42, 45, 43, 50, 60, 58, 0, 5, t2, t1));
			Item i1 = is.addItem(new Item(-1, 1, "Master Ball", 500, "100% catch rate", "BALL"));
			tis.saveTrainerItem(new TrainerItem(new TrainerItemsKey(), t1, i1, 3));
		};
	}
}
