package com.revature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.revature.keys.TrainerItemsKey;
import com.revature.models.Box;
import com.revature.models.Item;
import com.revature.models.Move;
import com.revature.models.Pokemon;
import com.revature.models.Role;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.models.TrainerItem;
import com.revature.services.ItemService;
import com.revature.services.MoveService;
import com.revature.services.PokemonService;
import com.revature.services.StorageService;
import com.revature.services.TrainerItemService;
import com.revature.services.TrainerService;

@SpringBootApplication
public class PokeMastersBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMastersBackApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://127.0.0.1:4200", "http://localhost:4200")
						.allowedMethods("GET", "POST", "PUT", "DELETE")
						.allowCredentials(true)
						.allowedHeaders("Content-Type", "Accept", "Authorization")
						.exposedHeaders("Content-Type", "Accept", "Authorization");
			}
		};
	}

	@Bean
	CommandLineRunner run(TrainerService ts, MoveService ms, PokemonService ps, ItemService is, TrainerItemService tis, StorageService ss) {
		return args -> {
			Trainer t1 = ts.saveTrainer(new Trainer(-1, "calvin", "1234", "pokemaster1", 100, Role.TRAINER));
			//Trainer t2 = ts.saveTrainer(new Trainer(-1, "elonmusk", "1234", "pokemaster", 100, Role.TRAINER));
			ts.saveTrainer(new Trainer(-1, "adam", "1234", "pokemaster2", 100, Role.ADMIN));
			ts.saveTrainer(new Trainer(-1, "kevin", "1234", "pokemaster3", 100, Role.TRAINER));
      /*
			ts.saveTrainer(new Trainer(-1, "adam", "1234", "pokemaster2", 100, new ArrayList<>(), Role.ADMIN, null));
			ts.saveTrainer(new Trainer(-1, "kevin", "1234", "pokemaster3", 100, new ArrayList<>(), Role.TRAINER, null));
      */
			ms.saveMove(new Move(-1, 3));
			Item i1 = is.addItem(new Item(-1, 1, "Master Ball", 500, "100% catch rate", "standard-balls", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/master-ball.png"));
			tis.saveTrainerItem(new TrainerItem(new TrainerItemsKey(), t1, i1, 3));
			Pokemon p1 = ps.createPokemon(new Pokemon(4, 5, t1));
			Pokemon p2 = ps.createPokemon(new Pokemon(1, 5, t1));
			Pokemon p3 = ps.createPokemon(new Pokemon(7, 5, t1));
			
			Storage s = new Storage();
			s.setActiveIndex(0);
			s.setBoxes(new Box[10]);
			for (int i=0; i<10; i++) {
				s.getBoxes()[i] = new Box();
				s.getBoxes()[i].setPokemon(new Pokemon[30]);
			}
			s.insert(p1);
			s.insert(p2);
			s.insert(p3);
			s.setTrainer(t1);
			ss.saveStorage(s);
			
		};
	}
}
