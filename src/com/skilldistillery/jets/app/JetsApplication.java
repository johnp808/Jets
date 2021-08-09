package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.*;

public class JetsApplication {
	private AirField airField = new AirField();
	List<Jet> jets = airField.getBunchOfJets();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jApp = new JetsApplication();

		jApp.run();
	}

//			METHODS
	public void run() {
		userMenu();
		goodbye();
	}

	public void loadPlanes() {
		airField.loadJets();

	}

	public void makePlanesFly() {
		for (Jet jet : jets) {
			System.out.println(jet.getModel() + " Is Flying");
		}
	}

	public void loadCargo() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}

	public void letsFight() {
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
//				System.out.println(jet.getModel() + " Coming In Hot..");
			}
		}
	}

	public void fastestJet() {
// 		list the airfield and check the speed of each jet >= to the last jets speed then print the fastest Jet
//		List<Jet> jets = airField.getBunchOfJets();
		double speed = 0;
		Jet fastestJet = jets.get(0);

		for (Jet jet : jets) {
			if (jet.getSpeed() > speed) {
				fastestJet = jet;
				speed = jet.getSpeed();
			}
		}
		System.out.println(fastestJet);
	}

	public void addJet() {
//			Scanner addJetScan = new Scanner(System.in);
		String name;
		String model;
		double speed;
		int range;
		long price;

		System.out.println("Select From The Made To Order Choices: Cargo Plane, Fighter Jet, Passenger Plane");
		name = kb.nextLine();
		System.out.println("Name Of The Model: ");
		model = kb.nextLine();
		System.out.println("Speed Of Model:  ");
		speed = kb.nextDouble();
		System.out.println("Range Of Model: ");
		range = kb.nextInt();
		System.out.println("Final Price Of The Model: ");
		price = kb.nextLong();

		Jet addUserJet = null;

		if (name.equalsIgnoreCase("Cargo Plane")) {
			addUserJet = new CargoPlane(model, speed, range, price);
		} else if (name.equalsIgnoreCase("Fighter Jet")) {
			addUserJet = new FighterJet(model, speed, range, price);
		} else if (name.equalsIgnoreCase("Passenger Plane")) {
			addUserJet = new PassengerPlane(model, speed, range, price);
		}

		jets.add(addUserJet);
		System.out.println("Newly Ordered: " + addUserJet.getModel() + " Added To The AirField.");

	}

	public void displayPlanes() {
			for (int i = 0; i < jets.size(); i++) {
				System.out.println(i + 1 + ")   " + jets.get(i));
			}
	}

	public void longestRange() {
// 		list the airfield and check the speed of each jet >= to the last jets speed then print the fastest Jet
		List<Jet> jets = airField.getBunchOfJets();
		int range = 0;
		Jet longestJetRange = jets.get(0);
		for (Jet jet : jets) {
			if (jet.getRange() > range) {
				longestJetRange = jet;
				range = jet.getRange();
			}
		}
		System.out.println(longestJetRange);
	}

	public void removeJet() {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + 1 + ")   " + jets.get(i));
		}
		System.out.println();
		System.out.println("Which Plane Is Headed To The Scrap Yard...");
		jets.remove(kb.nextInt() - 1);
	}

	public void goodbye() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"-   LLLL       EEEEEEEEEEEE          AAAA VV                VV IIIIIIIIIIIIIIII NNNNNN        NN GGGGGGGGGGGG       -");
		System.out.println(
				"-   LLLL       EEEEEEEEEEEE         AA  AA VV              VV  IIIIIIIIIIIIIIII NNNNNN        NN GGGGGGGGGGGG       -");
		System.out.println(
				"-   LLLL       EE                  AA    AA VV            VV         IIII       NN  NNN       NN GG                 -");
		System.out.println(
				"-   LLLL       EEEE               AA      AA VV          VV          IIII       NN   NNN      NN GG  GGGGGGGGGGGGGG -");
		System.out.println(
				"-   LLLL       EEEEEE            AAAAAAAAAAAA VV        VV           IIII       NN    NNN     NN GG  GGGGGGGGGGGGGG -");
		System.out.println(
				"-   LLLL       EEEE             AAAAAAAAAAAAAA VV      VV            IIII       NN     NNN    NN GG       GGGG      -");
		System.out.println(
				"-   LLLL       EE              AA            AA VV    VV             IIII       NN      NNN   NN GG       GGGG      -");
		System.out.println(
				"-   LLLLLLLLLL EEEEEEEEEEEEE  AA              AA VVVVVV        IIIIIIIIIIIIIIII NN       NNNNNNN GGGGGGGGGGGGG      -");
		System.out.println(
				"-   LLLLLLLLLL EEEEEEEEEEEEE AA                AA VVVV         IIIIIIIIIIIIIIII NN       NNNNNNN GGGGGGGGGGGGG      -");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------");
	}

	public void userMenu() {

		boolean quit = false;
		while (!quit) {

			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("-                                                 -");
			System.out.println("-      Please Select From One Of The Choices      -");
			System.out.println("-                                                 -");
			System.out.println("- 1.               * List Fleet *                 -");
			System.out.println("-                                                 -");
			System.out.println("- 2.              * Fly All Jets *                -");
			System.out.println("-                                                 -");
			System.out.println("- 3.            * View Fastest Jet *              -");
			System.out.println("-                                                 -");
			System.out.println("- 4.      * View Jet With Longest Range *         -");
			System.out.println("-                                                 -");
			System.out.println("- 5.           * Load All Cargo Jets *            -");
			System.out.println("-                                                 -");
			System.out.println("- 6.               * DogFight!!! *                -");
			System.out.println("-                                                 -");
			System.out.println("- 7.           * Add A Jet To Fleet  *            -");
			System.out.println("-                                                 -");
			System.out.println("- 8.          * Remove A Jet To Fleet  *          -");
			System.out.println("-                                                 -");
			System.out.println("- 9.           * This bores me, Quit *            -");
			System.out.println("-                                                 -");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");
			System.out.println("---------------------------------------------------");

			System.out.println("Enter your choice: ");
			String userMenuChoice = kb.nextLine();
			if (userMenuChoice.equals("1")) {
				displayPlanes();
			} else if (userMenuChoice.equals("2")) {
				makePlanesFly();
			} else if (userMenuChoice.equals("3")) {
				fastestJet();
			} else if (userMenuChoice.equals("4")) {
				longestRange();
			} else if (userMenuChoice.equals("5")) {
				loadCargo();
			} else if (userMenuChoice.equals("6")) {
				letsFight();
			} else if (userMenuChoice.equals("7")) {
				addJet();
			} else if (userMenuChoice.equals("8")) {
				removeJet();
			} else if (userMenuChoice.equals("9")) {
				quit = true;
				System.out.println();
			}
		}

	}
}
