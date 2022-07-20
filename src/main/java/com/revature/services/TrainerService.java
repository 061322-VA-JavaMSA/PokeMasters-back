package com.revature.services;

import com.revature.models.Role;
import com.revature.models.Trainer;
import com.revature.repositories.TrainerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional //https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
public class TrainerService {
    private final TrainerRepository tr;

    public Trainer saveTrainer(Trainer trainer) {
        return tr.save(trainer);
    }

    public void setRoleForTrainer(String username, Role role) {
        Trainer trainer = tr.findTrainerByUsername(username);
        trainer.setRole(role);
    }

    public Trainer getTrainer(String username) {
        return tr.findTrainerByUsername(username);
    }

    public List<Trainer> getTrainers() {
        return tr.findAll();
    }

}
