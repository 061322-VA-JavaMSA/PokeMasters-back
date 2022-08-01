package com.revature.services;

import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Role;
import com.revature.models.Trainer;
import com.revature.repositories.TrainerRepository;
import com.revature.security.CustomUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional //https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
public class TrainerService implements UserDetailsService {
    private TrainerRepository tr;
    private PasswordEncoder pe;

    public TrainerService(TrainerRepository tr, PasswordEncoder pe) {
        this.tr = tr;
        this.pe = pe;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Trainer trainer = tr.findTrainerByUsername(username);

        if (trainer == null) {
            System.out.println("No trainer with that username");
            throw new UsernameNotFoundException("No trainer with that username");
        } else {
            System.out.println("Trainer found in the database");
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(trainer.getRole().toString()));

        return new CustomUser(trainer.getId(), trainer.getUsername(), trainer.getPassword(), authorities);
    }

    public Trainer saveTrainer(Trainer trainer) {
        trainer.setPassword(pe.encode(trainer.getPassword()));
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

    public Trainer getbyId(int id) throws TrainerNotFoundException {
    	Optional<Trainer> t = tr.findById(id);

        if (!t.isPresent()) {
            System.out.println("No trainer with that ID");
            throw new TrainerNotFoundException();
        } else {
            System.out.println("Trainer found in the database");
        }

    	return t.get();
    }

    public void deleteTrainerById(int id) {
        tr.deleteById(id);
    }
}
