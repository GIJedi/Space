package Ships;

import Weapon.Weapon;
import Weapon.GatlingGun;
import Weapon.LaserCannon;
import Weapon.MissileLauncher;
public class BattleShip extends CapitalShip{
	private Weapon[] weapons = {new MissileLauncher(), new MissileLauncher(), new MissileLauncher(), new MissileLauncher(), 
								new LaserCannon(), new LaserCannon(), new LaserCannon(), new LaserCannon(), 
								new GatlingGun(), new GatlingGun(), new GatlingGun()};
	private static String type = "Battleship";
	private static int evasiveness = 2, health = 1000, shield = 250, shieldRenewRate = 50, speed = 1;
	public BattleShip(String name, boolean friendly) {
		super(type, name, evasiveness, health, shield, shieldRenewRate, speed, 0, 0, null, friendly);
		this.setWeapons(weapons);
	}

}
