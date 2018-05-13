package Weapon;

import Ships.Ship;

public class GatlingGun extends Weapon {
	
	public static final String name = "Gatling Gun";
	private static final int fireDelay = 1, damage = 2, accuracy = 75, health = 25, range = 1, numShots = 25;
	
	public GatlingGun(Ship ship) {
		super(name, fireDelay, damage, accuracy, health, range, ship);
	}

	public GatlingGun() {
		super(name, fireDelay, damage, accuracy, health, range, null);
	}
	@Override
	public void fire() {
		if(canFire()) {
			for(int i = 0; i < numShots; i++) {
				new Bullet(this);
			}
			startDelay();
		}
		else {
		}
	}
}
