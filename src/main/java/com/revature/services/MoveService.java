package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.MoveNotFoundException;
import com.revature.models.Move;
import com.revature.repositories.MoveRepository;

@Service
public class MoveService {

	private MoveRepository mr;
	
	public MoveService(MoveRepository mr) {
		this.mr = mr;
	}
	
	public Move getMoveById(int id) throws MoveNotFoundException {
		return mr.findById(id).orElseThrow(() -> new MoveNotFoundException());
	}
	
	public List<Move> getMoves() {
		return mr.findAll();
	}
	
	public Move saveMove(Move move) {
		return mr.save(move);
		
	}
	
}
