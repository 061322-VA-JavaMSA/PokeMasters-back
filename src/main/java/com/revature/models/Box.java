package com.revature.models;

public enum Box {
	PARTY(6), STORAGE(100), TRADE(5);
	
	Box(int size) {
		this.size = size;
	}

	private int size;
	
	public int size() {
		return size;
	}
}
