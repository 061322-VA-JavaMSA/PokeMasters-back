package com.revature.controllers;

import com.revature.models.Trainer;
import com.revature.services.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
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
    public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/trainers").toUriString());
        return ResponseEntity.created(uri).body(ts.saveTrainer(trainer));
    }
}
