package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;
import com.revature.models.Trainer;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, JpaSpecificationExecutor<Pokemon> {
	List<Pokemon> findPokemonByTrainer(Trainer t);

	List<Pokemon> findPokemonByApiId(int apiId);

}
