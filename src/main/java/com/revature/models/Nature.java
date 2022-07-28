package com.revature.models;

public enum Nature {
	HARDY("", ""), LONELY("att", "def"), BRAVE("att", "speed"), ADAMANT("att", "satt"), NAUGHTY("att", "sdef"),
	BOLD("def", "att"), DOCILE("", ""), RELAXED("def", "speed"), IMPISH("def", "satt"), LAX("def", "sdef"),
	TIMID("speed", "att"), HASTY("speed", "def"), SERIOUS("", ""), JOLLY("speed", "satt"), NAIVE("speed", "sdef"),
	MODEST("satt", "att"), MILD("satt", "def"), QUIET("satt", "speed"), BASHFUL("", ""), RASH("satt", "sdef"),
	CALM("sdef", "att"), GENTLE("sdef", "def"), SASSY("sdef", "speed"), CAREFUL("sdef", "satt"), QUIRKY("", "");

	private String inc, dec;

	Nature(String inc, String dec) {
		this.inc = inc;
		this.dec = dec;
	}

	public double mod(String s) {
		if (s.equals(this.inc)) {
			return 1.1;
		} else if (s.equals(this.dec)) {
			return 0.9;
		} else {
			return 1.0;
		}
	}
}
