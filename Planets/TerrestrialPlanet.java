package Planets;

import java.util.ArrayList;
import java.util.HashMap;

public class TerrestrialPlanet extends Planet{
	private double atmospherePressure, populationBillions;
	private ArrayList<String> gas;
	private HashMap<String, Double> atmosphere;
	
	public TerrestrialPlanet(String name, long mass, double radius, double radiation, double atmospherePressure, String gases[], double[] percentGases) {
		super(name, mass, radius, radiation);
		atmosphere = new HashMap<String, Double>();
		gas = new ArrayList<String>();
		createAtmosphere(gases, percentGases);
		this.atmospherePressure = atmospherePressure;
		populationBillions = 0;
	}
	
	public boolean checkAtmopshereHabitable() {
		double minOxygen = 0.19;
		double maxOxygen = 0.22;
		double currentOxygen = atmosphere.get("OXYGEN");
		double minPressure = 0.7;
		double maxPressure = 1.2;
		double maxCO2 = 0.01;
		double minCO2 = 0.0;
		double currentCO2 = atmosphere.get("CARBON DIOXIDE");
		boolean habitable = true;
		if(minOxygen > currentOxygen || maxOxygen < currentOxygen) {
			habitable = false;
		}
		if(minPressure > atmospherePressure || maxPressure < atmospherePressure) {
			habitable = false;
		}
		if(minCO2 > currentCO2 || currentCO2 < maxCO2) {
			habitable = false;
		}
		return habitable;
	}
	
	/**
	 * @param gas			list of gases
	 * @param percentGas	percent of each gas (KEEP IN SAME INDEX AS GAS)(22% = 0.22)
	 */
	private void createAtmosphere(String[] gas, double[] percentGas) {
		for(int i = 0; i <gas.length; i++) {
			this.gas.add(gas[i]);
			gas[i] = gas[i].toUpperCase();
			atmosphere.put(gas[i], percentGas[i]);
		}
	}
	
	/**
	 * @return population in billions
	 */
	public double getPopulation() {
		return populationBillions;
	}
	
	/**
	 * @param populationAddedBillions	number of people added in billions(can be negative)
	 */
	public void addPopulation(double populationAddedBillions) {
		populationBillions += populationAddedBillions;
	}
	/**
	 * @param populationBillions population in billions
	 */
	public void setPopulation(double populationBillions) {
		this.populationBillions = populationBillions;
	}
	public double getAtmospherePressure() {
		return atmospherePressure;
	}
	/**
	 * returns a percent as a double (0.2 for 20%)
	 * @param gas	name of gas
	 * @return		a double of percent of gas
	 */
	public double getGasPercent(String gas) {
		
		gas = gas.toUpperCase();
		return atmosphere.get(gas);
	}
}
