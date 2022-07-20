package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Pokemon not found.")
	@ExceptionHandler(PokemonNotFoundException.class)
	public void pokemonNotFound() {
		
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Item not found.")
	@ExceptionHandler(ItemNotFoundException.class)
	public void itemNotFound() {
		
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Trade not found.")
	@ExceptionHandler(TradeNotFoundException.class)
	public void tradeNotFound() {
		
	}
}
