package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.exceptions.TradeNotFoundException;
import com.revature.models.Trade;
import com.revature.models.Trainer;
import com.revature.repositories.TradeRepository;

@Service
public class TradeService {

	private TradeRepository tr;

	public TradeService(TradeRepository tr) {
		super();
		this.tr = tr;
	}
	
	public List<Trade> getTradesByOwner(Trainer owner) {
		return tr.findByOwner(owner);
	}
	
	public Trade getById(int id) throws TradeNotFoundException {
		return tr.findById(id).orElseThrow(() -> new TradeNotFoundException());
	}
	
	public Trade createTrade(Trade t) {
		t.setId(-1);
		return tr.save(t);
	}
	
	public Trade saveTrade(Trade t) {
		return tr.save(t);
	}
	
	public void deleteTrade(Trade t) {
		tr.delete(t);
	}
}
