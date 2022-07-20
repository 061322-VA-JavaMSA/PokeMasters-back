package com.revature.services;

import com.revature.exceptions.TradeNotFoundException;
import com.revature.models.Trade;
import com.revature.repositories.TradeRepository;

public class TradeService {

	private TradeRepository tr;

	public TradeService(TradeRepository tr) {
		super();
		this.tr = tr;
	}
	
	public Trade getById(int id) throws TradeNotFoundException {
		return tr.findById(id).orElseThrow(() -> new TradeNotFoundException());
	}
}
