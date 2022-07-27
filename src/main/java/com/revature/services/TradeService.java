package com.revature.services;

import java.util.List;

import com.revature.exceptions.TradeNotFoundException;
import com.revature.models.Trade;
import com.revature.models.Trainer;
import com.revature.repositories.TradeRepository;

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
	
	public Trade saveTrade(Trade t) {
		return tr.save(t);
	}
}
