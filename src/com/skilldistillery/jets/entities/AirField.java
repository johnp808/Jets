package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> bunchOfJets = new ArrayList<>();
	// add to array list
	public AirField() {
		super();
		loadJets();
	}
	public void loadJets() {
		// read from file and construct jet objects
		try {
			FileReader fr = new FileReader("jets.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
//				  PassengerPlane,boeing 757,12,456,123.45
				String[] pieces = line.split(",");
				Jet jet = null;
// if statement line index 0 .equals "cargoplane" "passengerplane" "fighterjet" etc."
//will call cargo plane, from jets.txt
// use wrapper class				  
// once created add jet to a bunch of jets for all jets		  
				if (pieces[0].equals("PassengerPlane")) {
					jet = new PassengerPlane(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				}
				else if (pieces[0].equals("FighterJet")) {
					jet = new FighterJet(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				} else if (pieces[0].equals("CargoPlane")) {
					jet = new CargoPlane(pieces[1], Double.parseDouble(pieces[2]),
							Integer.parseInt(pieces[3]), Long.parseLong(pieces[4]));
				}
				bunchOfJets.add(jet);
				System.out.println(jet);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + "jets.txt" + ": " + e.getMessage());
			return;
		}
		
		
	}

	public List<Jet> getBunchOfJets() {
		return bunchOfJets;
	}

	public void setBunchOfJets(List<Jet> bunchOfJets) {
		this.bunchOfJets = bunchOfJets;
	}
}

//		