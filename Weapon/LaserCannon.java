package Weapon;

import Ships.Ship;

public class LaserCannon extends Weapon{

	public static final String name = "Laser Cannon";
	private static final int fireDelay = 1, damage = 75, accuracy = 65, health = 25, range = 4;
	public LaserCannon(Ship ship) {
		super(name, fireDelay, damage, accuracy, health, range, ship);
	}

	public LaserCannon() {
		super(name, fireDelay, damage, accuracy, health, range, null);
	}
	@Override
	public void fire() {
		if(canFire()) {
			new LaserBolt(this);
			startDelay();
		}
		else {
			System.out.println("Cannot Fire: " + name);
		}
	}
}
