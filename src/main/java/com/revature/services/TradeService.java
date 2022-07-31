package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.exceptions.StorageFullException;
import com.revature.exceptions.TradeNotFoundException;
import com.revature.models.Status;
import com.revature.models.Trade;
import com.revature.models.Trainer;
import com.revature.repositories.TradeRepository;
import com.revature.specifications.TradeSpecifications;

@Service
public class TradeService {

	private TradeRepository tr;
	private PokemonService ps;

	public TradeService(TradeRepository tr, PokemonService ps) {
		super();
		this.tr = tr;
		this.ps = ps;
	}

	public List<Trade> getTrades() {
		return tr.findAll();
	}

	public Trade getById(int id) throws TradeNotFoundException {
		return tr.findById(id).orElseThrow(() -> new TradeNotFoundException());
	}

	public Trade createTrade(Trade t) {
		t.setId(-1);
		return tr.save(t);
	}
	
	public List<Trade> getOwnedTrades(Trainer t) {
		return tr.findAll(TradeSpecifications.ownedBy(t).and(TradeSpecifications.notCompleted()));
	}
	
	public List<Trade> getAvailableTrades(Trainer t) {
		return tr.findAll(TradeSpecifications.notOwnedBy(t).and(TradeSpecifications.notCompleted()));
	}

	@Transactional
	public Trade updateTrade(Trade t) throws StorageFullException {
		switch (t.getStatus()) {
		case PENDING:
			if (t.getOffered() != null) {
				Trainer temp = t.getOffered().getTrainer();
				t.getOffered().setTrainer(t.getListed().getTrainer());
				t.getListed().setTrainer(temp);
				ps.receivePokemon(t.getListed());
				ps.savePokemon(t.getOffered());
				t.setStatus(Status.ACCEPTED);
			}
			break;
		case ACCEPTED:
			ps.receivePokemon(t.getOffered());
			t.setStatus(Status.COMPLETED);
		default:
		}
		return tr.save(t);
	}

	public ResponseEntity<String> deleteTrade(Trade t) throws StorageFullException {
		switch (t.getStatus()) {
		case PENDING:
			if (t.getOffered() == null) {
				ps.receivePokemon(t.getListed());
				String name = t.getListed().getNickname() == null || t.getListed().getNickname().equals("")
						? t.getListed().getNickname()
						: t.getListed().getName();
				tr.delete(t);
				return ResponseEntity.ok("The trade was cancelled. " + name + " was returned to its owner.");
			}
		case COMPLETED:
			return ResponseEntity.ok("The trade was removed.");
		default:
			return new ResponseEntity<String>("Unable to cancel/remove this trade.", HttpStatus.BAD_REQUEST);
		}
	}
}
