package com.skilldistillery.jets.entities;

//cargo plane extends jet implements cargo carrier
public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("Currently Loading Cargo For: " + this.getModel());
	}

}
