package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.exceptions.StorageNotFoundException;
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
		return sr.save(s);
	}
	
	public Storage saveStorage(Storage s) {
		return sr.save(s);
	}
	
	public void deleteStorage(Storage s) {
		sr.delete(s);
	}
}
