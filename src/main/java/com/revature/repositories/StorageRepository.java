package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Storage;
import com.revature.models.Trainer;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Integer> {

	Storage findByTrainer(Trainer t);
}
