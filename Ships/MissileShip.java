package Ships;

import Weapon.GatlingGun;
import Weapon.LaserCannon;
import Weapon.MissileLauncher;
import Weapon.Projectile;
import Weapon.Weapon;

public class MissileShip extends CapitalShip{
	private Weapon[] weapons = {new MissileLauncher(), new MissileLauncher(), new MissileLauncher(), new MissileLauncher(), 
								new MissileLauncher(), new MissileLauncher(), new MissileLauncher(), new MissileLauncher()};
	private static String type = "MissileShip";
	private static int evasiveness = 4, health = 750, shield = 250, shieldRenewRate = 50, speed = 2;
	public MissileShip(String name, boolean friendly) {
		super(type, name, evasiveness, health, shield, shieldRenewRate, speed, 0, 0, null, friendly);
		this.setWeapons(weapons);
	}
}
