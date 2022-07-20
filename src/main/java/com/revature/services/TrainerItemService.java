package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.models.TrainerItem;
import com.revature.repositories.TrainerItemRepository;

@Service
public class TrainerItemService {

	private TrainerItemRepository tir;

	public TrainerItemService(TrainerItemRepository tir) {
		super();
		this.tir = tir;
	}
	
	public List<TrainerItem> getItems() {
		return tir.findAll();
	}
	
	public TrainerItem saveTrainerItem(TrainerItem ti) {
		return tir.save(ti);
	}
}
