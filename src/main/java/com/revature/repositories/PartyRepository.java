package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Party;
import com.revature.models.Trainer;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer>{

	Party findByTrainer(Trainer t);
}
