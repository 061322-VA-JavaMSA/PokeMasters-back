package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.models.Party;
import com.revature.models.Trainer;
import com.revature.repositories.PartyRepository;

@Service
public class PartyService {

	private PartyRepository pr;

	public PartyService(PartyRepository pr) {
		super();
		this.pr = pr;
	}
	
	public Party getPartyByTrainer(Trainer t) {
		return pr.findByTrainer(t);
	}
	
	public Party saveParty(Party p) {
		return pr.save(p);
	}
}
