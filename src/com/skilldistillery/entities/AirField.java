package com.skilldistillery.entities;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	
	
	private List<Jet> jets;
	
	public AirField() {
		jets = new ArrayList<Jet>();
	}
	//first menu option
	public void displayFleet() {
		for (Jet jet : jets) {
			System.out.println(jet.toString());
		}
	}
	
	//second menu option
	
	public void fly() {
//		double flightTime;
		for (Jet jet : jets) {
		System.out.println(jet.toString());
		
		}
	}
		//third menu option
	public Jet displayFastest() {
		Jet fastestJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		return fastestJet;
	}
	
	//fourth menu option
	public Jet displayLongestRange() {
		Jet longestRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		return longestRange;

		
	}
	//fifth option
	public List<Jet> loadAllCargoPlanes() {
		List<Jet> cargoPlanes = new ArrayList<>();
		for (Jet jet : cargoPlanes) {
			if (jet instanceof CargoCarrier) {
				cargoPlanes.add(jet);
				((CargoCarrier)jet).loadCargo();
			}
		}
		return cargoPlanes;
	} 
	//sixth option
	public List<Jet> dogfightNow() {
		List<Jet> fighterPlanes = new ArrayList<>();
		for (Jet jet : fighterPlanes) {
			if (jet instanceof FighterJet) {
				fighterPlanes.add(jet);
				((FighterJet)jet).fight();
			}
		}
		return fighterPlanes;
	} 
	
	//seventh option
	// Moved to jetsApp switch case menu
	public void addJet(Jet jet) {
		jets.add(jet);
	}
	
	
	
	public List<Jet> getJets() {
		return jets;
	}
	
	public void setJets(List<Jet> jets) {
		this.jets = jets;
		
	}
	
}
