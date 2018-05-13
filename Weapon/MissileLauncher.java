package Weapon;

import Ships.Ship;

public class MissileLauncher extends Weapon {
	public static final String name = "Missile Launcher";
	private static final int fireDelay = 3, damage = 100, accuracy = 85, health = 25, range = 10;
	public MissileLauncher(Ship ship) {
		super(name, fireDelay, damage, accuracy, health, range, ship);
	}

	public MissileLauncher() {
		super(name, fireDelay, damage, accuracy, health, range, null);
	}
	@Override
	public void fire() {
		//System.out.println(name + ": fire delay: " + this.getFireDelay());
		if(canFire()) {
			//System.out.println("Fire");
			new Missile(this);
			startDelay();
			//System.out.println("\t" + name + ": fire delay: " + this.getFireDelay());
		}
		else {
			//System.out.println("Cannot Fire: " + name);
		}
		
	}
	
}
