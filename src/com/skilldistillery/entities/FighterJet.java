package com.skilldistillery.entities;

public class FighterJet extends Jet implements CombatReady  {


	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fight() {
		System.out.println("Dogfighting now: " + getModel() + " Pew Pew Pew Pew!!! ");
		
	}

	@Override
	public void fly() {
		System.out.println("Pew Pew");
		
	}

}
