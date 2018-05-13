package Ships;

import Interfaces.Targetable;
import Weapon.Weapon;

public abstract class Fighter extends Ship{
	private Weapon weapon;
	public Fighter(String type, String name, int evasiveness, int health, int shield, int shieldRenewRate, int speed, int x, int y, Weapon weapon, boolean friendly) {
		super(type, name, evasiveness, health, shield, shieldRenewRate, speed, y, y, friendly);
		this.weapon = weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.weapon().setShip(this);
		calcStrength(health());
	}
	public boolean canFire() {
		return weapon().canFire();
	}
	public void fire() {
		weapon.fire();
	}
	public Weapon weapon() {
		return weapon;
	}
	@Override
	public void turn() {
		resetSpeed();
		chargeShield();
		weapon.turn();
	}

	@Override
	public void setTarget(Targetable target) {
		this.target = target;
		this.weapon.setTarget(target);
	}
	@Override
	protected void calcStrength(int health) {
		if(weapon != null) {
			this.setStrength(health + weapon.strength());
		}
		else {
			this.setStrength(health);
		}
	}
}
