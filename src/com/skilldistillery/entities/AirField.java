package com.skilldistillery.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> jets; 

	public AirField() {
		jets = new ArrayList<Jet>();
	}

	public void initializeJets(String fileName) throws Exception {

//		List<Jet> jets = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetData = line.split(",");
				String name = jetData[0];
				String model = jetData[1];
				double speed = Double.parseDouble(jetData[2]);
				int range = Integer.parseInt(jetData[3]);
				long price = Long.parseLong(jetData[4]);
				Jet jet = null;
				if (jetData[0].equals("FighterJet")) {
					jet = new FighterJet(model, speed, range, price);
					
	
				} else if (jetData[0].equals("CargoPlane")) {
					jet = new CargoPlane(model, speed, range, price);
				
				} else {
					jet = new OtherPlane(model, speed, range, price);
					
					
				}
				
				jets.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

//		setJets(jets);
	}

	// first menu option
	public void displayFleet() {
		for (Jet jet : jets) {
			System.out.println(jet.toString());
		}
	}

	// second menu option

	public void fly() {
//		double flightTime;
		for (Jet jet : jets) {
			double duration = jet.getRange() / jet.getSpeed();
			System.out.println("Model " + jet.getModel() + " is flying for about "
					+ Math.round(duration) + " hours");

		}
	}

	// third menu option
	public Jet displayFastest() {
		Jet fastestJet = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getSpeed() > fastestJet.getSpeed()) {
				fastestJet = jet;
			}
		}
		return fastestJet;
	}

	// fourth menu option
	public Jet displayLongestRange() {
		Jet longestRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		return longestRange;

	}

	// fifth option
	public void loadAllCargoPlanes() {
		
		for (Jet jet : jets) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier)jet).loadCargo();
				
			}
		}
		
	}

	// sixth option
	public void dogfightNow() {
	
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	
	}

	// seventh option
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
