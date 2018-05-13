package Interfaces;

import Weapon.Projectile;

public interface Targetable extends Coordinate{
	public void shoot(Projectile p);
	public void setTarget(Targetable t);
	public boolean destroyed();
	public int evasiveness();
}
