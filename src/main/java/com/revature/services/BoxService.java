package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.models.Box;
import com.revature.repositories.BoxRepository;

@Service
public class BoxService {

	private BoxRepository br;

	public BoxService(BoxRepository br) {
		super();
		this.br = br;
	}
	
	public Box saveBox(Box b) {
		return br.save(b);
	}
}
