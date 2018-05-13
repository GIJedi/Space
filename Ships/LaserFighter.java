package Ships;

import Interfaces.Targetable;
import Weapon.LaserCannon;
import Weapon.Weapon;

public class LaserFighter extends Fighter{
	public static String type = "Laser Fighter", name = "Laser Fighter";
	private static int evasiveness = 95, health = 2, shield = 5, shieldRenewRate = 1, speed = 8;
	private Weapon weapon = new LaserCannon();
	public LaserFighter(boolean friendly) {
		super(type, name, evasiveness, health, shield, shieldRenewRate, speed, 0, 0, null, friendly);
		setWeapon(weapon);
	}
	public static int evasiveness(int putWhatever) {
		return evasiveness;
	}
	
}
