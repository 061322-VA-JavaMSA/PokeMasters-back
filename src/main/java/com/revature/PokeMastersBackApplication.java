package com.revature;

import com.revature.keys.TrainerItemsKey;
import com.revature.models.*;
import com.revature.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
