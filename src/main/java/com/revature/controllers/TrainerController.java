package com.revature.controllers;

import com.revature.exceptions.TrainerNotFoundException;
import com.revature.models.Party;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.services.PartyService;
import com.revature.services.StorageService;
import com.revature.services.TrainerService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TrainerController {
    private TrainerService ts;
    private StorageService ss;
    private PartyService ps;

    public TrainerController(TrainerService ts, StorageService ss, PartyService ps) {
        this.ts = ts;
        this.ps  = ps;
        this.ss = ss;
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
            Storage s = new Storage();
			s.setTrainer(t);
			ss.createStorage(s);
			Party p = new Party();
			p.setTrainer(t);
			ps.saveParty(p);
            return ResponseEntity.created(uri).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exist");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
        }
    }
    
    @GetMapping("/trainers/{id}")
    public ResponseEntity<Trainer> getById(@PathVariable int id) throws TrainerNotFoundException {
    	return new ResponseEntity<>(ts.getbyId(id), HttpStatus.OK);
    }
    
    @PutMapping("/trainers/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable int id, @RequestBody Object obj) throws TrainerNotFoundException {
    	String[] money = obj.toString().split("=");
    	int cash = Integer.parseInt(money[1].replace("}", ""));
    	Trainer t = ts.getbyId(id);
    	t.setMoney(cash);
    	ts.saveTrainer(t);
    	
    	return new ResponseEntity<>(ts.saveTrainer(t), HttpStatus.OK);
    }

    @DeleteMapping("/trainers/{id}")
    public ResponseEntity<Trainer> deleteTrainerById(@PathVariable int id) {
        ts.deleteTrainerById(id);
        return ResponseEntity.ok().build();
    }
}
