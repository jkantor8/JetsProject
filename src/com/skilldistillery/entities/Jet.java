package com.skilldistillery.entities;

public abstract class Jet {
// add jets to a list
	private String model;
	private double speed;
	private int range;
	private long price;
	

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public double getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public long getPrice() {
		return price;
	}

	

	public void fight() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

	
}