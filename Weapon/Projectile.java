package Weapon;

import java.io.PrintWriter;

public abstract class Projectile {
	protected Weapon weapon;
	private int damage;
	public Projectile(Weapon weapon) {
		this.weapon = weapon;
		this.damage = weapon.getDamage();
		weapon.target().shoot(this);
	}
	
	public boolean checkHit() {
		int chance = (int) (Math.random() * 100);
		int dodge = (weapon.accuracy() * (100 - weapon.target().evasiveness())) / 100;
		if(chance < dodge) {
			return true;
		}
		else {
			return false;
		}
	}
	public int damage() {
		return damage;
	}
	protected abstract void showAnimation();
}
