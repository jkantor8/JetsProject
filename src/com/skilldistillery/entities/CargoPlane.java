package com.skilldistillery.entities;

public class CargoPlane extends Jet implements CargoCarrier {

	
	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void loadCargo() {
		System.out.println("Loading cargo now on " + this.getModel() );
	}
//	@Override
//	public void fly() {
//		// TODO Auto-generated method stub
//		
//	}
}
