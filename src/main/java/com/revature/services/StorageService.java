package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.exceptions.StorageNotFoundException;
import com.revature.models.Box;
import com.revature.models.Pokemon;
import com.revature.models.Storage;
import com.revature.models.Trainer;
import com.revature.repositories.StorageRepository;

@Service
public class StorageService {

	private StorageRepository sr;

	public StorageService(StorageRepository sr) {
		super();
		this.sr = sr;
	}
	
	public Storage getStorageById(int id) throws StorageNotFoundException {
		return sr.findById(id).orElseThrow(() -> new StorageNotFoundException());
	}
	
	public Storage getStorageByTrainer(Trainer t) {
		return sr.findByTrainer(t);
	}
	
	public Storage createStorage(Storage s) {
		s.setId(-1);
		Box[] boxes = new Box[10];
		for (int i=0; i< 10; i++) {
			boxes[i] = new Box();
			boxes[i].setId(-1);
			boxes[i].setName("BOX " + (i + 1));
			boxes[i].setPokemon(new Pokemon[30]);
		}
		s.setBoxes(boxes);
		s.setActiveIndex(0);
		return sr.save(s);
	}
	
	public Storage saveStorage(Storage s) {
		return sr.save(s);
	}
	
	public void deleteStorage(Storage s) {
		sr.delete(s);
	}
}
