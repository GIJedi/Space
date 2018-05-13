package Planets;

public class Planet {
	private double mass, radius, gravity, radiation, atmospherePressure;
	private String name;
	
	/**
	 * Creates a planet
	 * @param name					name	
	 * @param massmillionK			mass in Million of Kilograms (9000000000 = 9)
	 * @param radius				in KM
	 * @param radiation				in whatever units
	 * @param atmospherePressure	in 
	 */
	public Planet(String name, double mass, double radius, double radiation) {
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		gravity = calcGravity();
		this.radiation = radiation;
	}
	
	public String getName() {
		return name;
	}
	public double getMass() {
		return mass;
	}
	private double calcGravity() {
		double G = 6.67 * Math.pow(10, -11);
		return G * mass / Math.pow(radius, 2);
	}
	
	
	

	
}
