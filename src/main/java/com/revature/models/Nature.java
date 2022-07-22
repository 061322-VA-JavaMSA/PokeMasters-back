package com.revature.models;

public enum Nature {
	HARDY(StatType.NONE, StatType.NONE), LONELY(StatType.PA, StatType.PD), BRAVE(StatType.PA, StatType.SP), ADAMANT(StatType.PA, StatType.SA), NAUGHTY(StatType.PA, StatType.SD), BOLD(StatType.PD, StatType.PA), DOCILE(StatType.NONE, StatType.NONE),
	RELAXED(StatType.PD, StatType.SP), IMPISH(StatType.PD, StatType.SA), LAX(StatType.PD, StatType.SD), TIMID(StatType.SP, StatType.PA), HASTY(StatType.SP, StatType.PD), SERIOUS(StatType.NONE, StatType.NONE), JOLLY(StatType.SP, StatType.SA), NAIVE(StatType.SP, StatType.SD), MODEST(StatType.SA, StatType.PA), MILD(StatType.SA, StatType.PD), QUIET(StatType.SA, StatType.SP), BASHFUL(StatType.NONE, StatType.NONE), RASH(StatType.SA, StatType.SD), CALM(StatType.SD, StatType.PA), GENTLE(StatType.SD, StatType.PD), SASSY(StatType.SD, StatType.SP),
	CAREFUL(StatType.SD, StatType.SA), QUIRKY(StatType.NONE, StatType.NONE);

	private StatType adv;
	private StatType dis;

	Nature(StatType adv, StatType dis) {
		this.adv = adv;
		this.dis = dis;
	}
	
	public StatType adv() {
		return this.adv;
	}
	
	public StatType dis() {
		return this.dis;
	}
}
