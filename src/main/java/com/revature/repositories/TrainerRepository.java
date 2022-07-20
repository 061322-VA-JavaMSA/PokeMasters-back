package com.revature.repositories;

import com.revature.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    Trainer findTrainerByUsername(String username);
}