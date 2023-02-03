package com.skilldistillery.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.entities.AirField;
import com.skilldistillery.entities.CargoPlane;
import com.skilldistillery.entities.FighterJet;
import com.skilldistillery.entities.Jet;
import com.skilldistillery.entities.OtherPlane;

public class JetsApp {
	private AirField airfield = new AirField();
	List<Jet> jets = new ArrayList<>();

	public JetsApp() {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JetsApp j = new JetsApp();
		j.launch();
	}

	private void launch() {

		
			try {
				airfield.initializeJets("jets.txt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		displayUserMenu();
	}

	private int getMenuChoice() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	private void displayUserMenu() {
		int menuChoice;
		
		Scanner input = new Scanner(System.in);
		do {
			System.out.println(" ------------------------------- ");
			System.out.println("| User Menu:                    |");
			System.out.println("| 1. List Fleet                 |");
			System.out.println("| 2. Fly all Jets               |");
			System.out.println("| 3. View fastest jet           |");
			System.out.println("| 4. View jet with longest range|");
			System.out.println("| 5. Load all Cargo Jets        |");
			System.out.println("| 6. Dogfight!                  |");
			System.out.println("| 7. Add a jet to Fleet         |");
			System.out.println("| 8. Remove a jet from Fleet    |");
			System.out.println("| 9. Quit                       |");
			System.out.println(" ------------------------------- ");

			menuChoice = getMenuChoice();

			// write switch case for the menu options
			switch (menuChoice) {
			case 1:
				airfield.displayFleet();
				break;
			case 2:
				airfield.fly();
				break;
			case 3:
				Jet fastestJet = airfield.displayFastest();
				System.out.println("Fastest Jet: " + fastestJet);
				break;
			case 4:
				Jet longestRange = airfield.displayLongestRange();
				System.out.println("Longest Range Jet:" + longestRange);
				break;
			case 5:
				airfield.loadAllCargoPlanes();

				break;
			case 6:
				airfield.dogfightNow();

				break;
			case 7:
				System.out.println("Model?");
				String model = input.nextLine();
				System.out.println("Speed?");
				double speed = input.nextDouble();
				System.out.println("Range?");
				int range = input.nextInt();
				System.out.println("Price?");
				long price = input.nextLong();

				Jet newJet = new OtherPlane(model, speed, range, price);
				airfield.addJet(newJet);
				break;
			case 8:
				System.out.println("Which number jet do you want to remove?");
				for (int i = 0; i < airfield.getJets().size(); i++) {
					System.out.println(i + 1 + " - " + airfield.getJets().get(i).getModel());
				}
				int jetNumberRemoved = input.nextInt();
				airfield.getJets().remove(jetNumberRemoved - 1);
				System.out.println("Jet #" + jetNumberRemoved + " removed!");
				break;
			case 9:
				System.out.println("Quitting program!");
				break;
			default:

				System.out.println("Enter a number 1 to 9");
				break;
			}
		} while (menuChoice != 9);

	}

	

}
