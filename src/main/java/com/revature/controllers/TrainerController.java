package com.revature.controllers;

import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TrainerController {
    private TrainerService ts;

    public TrainerController(TrainerService ts) {
        this.ts = ts;
    }

    @GetMapping("/trainers")
    public ResponseEntity<List<Trainer>> getTrainers() {
        return ResponseEntity.ok().body(ts.getTrainers());
    }

    @PostMapping("/trainers")
    public ResponseEntity<String> saveTrainer(@RequestBody Trainer trainer) {
        try {
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/trainers").toUriString());
            Trainer t = ts.saveTrainer(trainer);
            return ResponseEntity.created(uri).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }
    }
}
