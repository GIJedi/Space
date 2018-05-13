package Ships;
import java.io.PrintWriter;

import Interfaces.Coordinate;
import Interfaces.Targetable;
import Weapon.Weapon;

public abstract class CapitalShip extends Ship{
	private Weapon[] weapons;
	
	/**
	 * 
	 * @param evasiveness		Chance a ship can dodge a projectile 0 - 100
	 * @param health			health a ship has
	 * @param shield			health of shield
	 * @param shieldRenewRate	health shield renewed per turn
	 * @param x					initial x pos
	 * @param y					initial y pos
	 * @param weapons			weapons that ship has
	 * @param friendly			friendly or enemy ship
	 */
	public CapitalShip(String type, String name, int evasiveness, int health, int shield, int shieldRenewRate,
			int speed, int x, int y, Weapon[] weapons, boolean friendly) {
		super(type, name, evasiveness, health, shield, shieldRenewRate, speed, x, y, friendly);
		// TODO Auto-generated constructor stub
	}
	
	protected void setWeapons(Weapon[] weapons) {
		this.weapons = weapons;
		for(int i = 0; i < weapons.length; i++) {
			this.weapons[i].setShip(this);
		}
		calcStrength(maxHealth());
	}
	/**
	 * fires a certain number of weapons with the specified name
	 * @param weaponName
	 * @param numToFire
	 */
	public void fire(String weaponName, int numToFire) {
		for(int i = 0; i < weapons.length && numToFire > 0; i++) {
			//System.out.println(weapons[i].name().equals(weaponName) + " && " + weapons[i].canFire());
			if(weapons[i].name().equals(weaponName) && weapons[i].canFire()) {
				//System.out.println("Weapon Found");
				//System.out.println(numToFire + " to " + (numToFire--));
				numToFire--;
				weapons[i].fire();
			}
			//System.out.println(numToFire);
		}
	}
	public void setTarget(Targetable target) {
		this.target = target;
		for(int i = 0; i < weapons.length; i++) {
			weapons[i].setTarget(target);
		}
	}
	public Weapon weapon(int i) {
		return weapons[i];
	}
	/**
	 * fires all with specified name
	 * @param name
	 */
	public void fireAll(String name) {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i].name().equals(name)) {
				weapons[i].fire();
			}
		}
	}
	public boolean canFire() {
		for(int i = 0; i < weapons.length; i++) {
			if(weapons[i].canFire()) {
				return true;
			}
		}
		return false;
	}
	public void fireAll() {
		for(int i = 0; i < weapons.length; i++) {
			weapons[i].fire();
		}
	}
	public void turn() {
		chargeShield();
		for(int i = 0; i < weapons.length; i++) {
			weapons[i].turn();
		}
		resetSpeed();
	}
	public Weapon[] weapons() {
		return weapons;
	}
	public String toString() {
		String returnString = String.format("%15s %4d %4d %4d %6s%6s%n", name(), strength(), health(), shield(), isFriendly(), destroyed());
		for(int i = 0; i < weapons.length; i++) {
			returnString += weapons[i].name() + "\n\t";
		}
		return returnString;
	}
	protected void calcStrength(int s) {
		if(weapons != null) {
			for(int i = 0; i < weapons.length; i++) {
				s += weapons[i].strength();
			}
		}
		setStrength(s);
	}
}
