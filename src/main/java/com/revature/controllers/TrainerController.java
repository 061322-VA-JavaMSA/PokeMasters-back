package com.revature.controllers;

import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.http.MediaType;
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

    @PostMapping(path = "/trainers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/trainers").toUriString());
        return ResponseEntity.created(uri).body(ts.saveTrainer(trainer));
    }
}
