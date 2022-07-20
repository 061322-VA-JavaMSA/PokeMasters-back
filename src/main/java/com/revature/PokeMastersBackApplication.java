package com.revature;

import com.revature.models.Role;
import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PokeMastersBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeMastersBackApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TrainerService ts) {
		return args -> {
			ts.saveTrainer(new Trainer(-1, "elonmusk", "1234", "pokemaster", 100, Role.TRAINER));
			ts.saveTrainer(new Trainer(-1, "calvin", "1234", "pokemaster1", 100, Role.TRAINER));
			ts.saveTrainer(new Trainer(-1, "adam", "1234", "pokemaster2", 100, Role.ADMIN));
			ts.saveTrainer(new Trainer(-1, "kevin", "1234", "pokemaster3", 100, Role.TRAINER));
		};
	}
}
