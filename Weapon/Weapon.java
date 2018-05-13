package Weapon;


import Interfaces.Targetable;
import Ships.Ship;

public abstract class Weapon {
	private String name;
	private int  damage, health, maxHealth, strength, accuracy, fireDelay, range;
	private double fireDelayModifier, damageModifier;
	private Ship ship;
	private Targetable target;
	private int delayCount = 0;
	public Weapon(String name, int fireDelay, int damage, int accuracy, int health, int range, Ship ship) {
		this.name = name;
		this.range = range;
		this.fireDelay = fireDelay;
		this.damage = damage;
		this.accuracy = accuracy;
		this.strength = health;
		fireDelayModifier = 1;
		damageModifier = 1;
		this.ship = ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public int range() {
		return range;
	}
	public void setTarget(Targetable target) {
		this.target = target;
	}
	public Targetable target() {
		return target;
	}
	public int accuracy() {
		return accuracy;
	}
	public Ship ship() {
		return ship;
	}
	public int strength() {
		return strength;
	}
	public int health() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void subtractHealth(int num) {
		this.health -=num;
	}
	public void addHealth(int num) {
		this.health += num;
	}
	public String name() {
		return name;
	}
	public int getFireDelay() {
		return (int) (fireDelay * (fireDelayModifier));
	}
	public int getDamage() {
		return (int) (damage * (damageModifier));
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFireDelay(int fireDelay) {
		this.fireDelay = fireDelay;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public double damageModifier() {
		return damageModifier;
	}
	
	public double fireDelayModifier() {
		return fireDelayModifier;
	}
	
	public void setFireDelayModifier(double fireDelayModifier) {
		this.fireDelayModifier = fireDelayModifier;
	}
	
	public void setDamageModifier(double damageModifier) {
		this.damageModifier = damageModifier;
	}
	public boolean canFire() {
		if(target == null) {
			//System.out.println("Weapon " + this.name() + " Cannot Fire: No Target");
			return false;
		}
		if(delayCount == 0) { 
			if(ship.calcDistance(target) <= range) {
				return true; 
			}
			else {
				//System.out.println("Weapon " + this.name() + " Cannot Fire: Out of Range");
			}
		}
		else {
			//System.out.println("Weapon " + this.name() + " Cannot Fire: " + delayCount + " turns to cooldown");
		}
		return false;
	}
	public void startDelay() {
		delayCount = getFireDelay();
	}
	public void turn() {
		//System.out.println("Weapon: " + name + "\tdelayCount = " + delayCount);
		delayCount--;
		if(0 > delayCount) {
			delayCount = 0;
		}
	}
	public abstract void fire();
}
