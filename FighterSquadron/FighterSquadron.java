package FighterSquadron;

import java.util.ArrayList;

import Interfaces.Coordinate;
import Interfaces.Targetable;
import Ships.Fighter;
import Weapon.Projectile;
/**
 * @todo if a shot misses one, then see if it hits the next one
 * @author mailn
 *
 */
public abstract class FighterSquadron implements Targetable{
	private ArrayList<Fighter> fighters;
	private String name, type;
	private boolean destroyed, friendly;
	private int x, y, maxSize, evasiveness, strength;
	private Targetable target;
	
	public FighterSquadron(String type, String name, int maxSize, int evasiveness, boolean friendly) {
		this.type = type;
		this.name = name;
		this.maxSize = maxSize;
		this.evasiveness = evasiveness;
		this.friendly = friendly;
		destroyed = false;
		x = 0;
		y = 0;
		target = null;
		fighters = new ArrayList<Fighter>();
	}
	public int currentSize() {
		return fighters.size();
	}
	public boolean canFire() {
		for(int i = 0; i < fighters.size(); i++) {
			if(fighters.get(i).canFire()) {
				return true;
			}
		}
		return false;
	}
	public int strength() {
		return strength;
	}
	public void calcStrength() {
		int s = 0;
		for(int i = 0; i < fighters.size(); i++) {
			s += fighters.get(i).strength();
		}
		this.strength = s;
	}
	public abstract String toString();
	public boolean friendly() {
		return friendly;
	}
	public String name() {
		return name;
	}
	public String type() {
		return type;
	}
	public int maxSize() {
		return maxSize;
	}
	public Targetable target() {
		return target;
	}
	public void addFighter(Fighter fighter) {
		fighters.add(fighter);
		calcStrength();
	}
	public void addFighters(Fighter[] fighters) {
		for(int i = 0; i < fighters.length; i++) {
			this.fighters.add(fighters[i]);
		}
		calcStrength();
	}
	public void addFighters(ArrayList<Fighter> fighters) {
		for(int i = 0; i < fighters.size(); i++) {
			this.fighters.add(fighters.get(i));
		}
		calcStrength();
	}
	public void shoot(Projectile p) {
		for(int i = 0; i < fighters.size(); i++) {
			if(p.checkHit()) {
				fighters.get(i).damage(p.damage());
				//System.out.println("Fighter Hit");
			}
		}
		checkDestroyed();
	}
	private void checkDestroyed() {
		for(int i = 0; i < fighters.size(); i++) {
			if(fighters.get(i).destroyed()) {
				fighters.remove(i);
			}
		}
		if(fighters.size() == 0) {
			destroyed = true;
		}
		calcStrength();
	}
	@Override
	public int xPos() {
		return x;
	}
	@Override
	public int yPos() {
		return y;
	}
	@Override
	public void setX(int i) {
		x = i;
	}
	@Override
	public void setY(int i) {
		y = i;
	}
	@Override
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public void addX(int i) {
		x += i;
	}
	@Override
	public void addY(int i) {
		y += i;
	}
	@Override
	public double calcDistance(Coordinate c) {
		return Math.sqrt(Math.pow(c.xPos() - x, 2) + Math.pow(c.yPos() - y, 2));
	}
	@Override
	public double calcDistance(int x, int y) {
		return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
	}
	@Override
	public void setTarget(Targetable t) {
		this.target = t;
		for(int i = 0; i < fighters.size(); i++) {
			fighters.get(i).setTarget(t);
		}
	}
	@Override
	public boolean destroyed() {
		return destroyed;
	}
	@Override
	public int evasiveness() {
		return fighters.get(0).evasiveness();
	}
	public void fireAll() {
		for(int i = 0; i < fighters.size(); i++) {
			fighters.get(i).fire();
		}
	}
	public void fire(int n) {
		for(int i = 0; i < fighters.size() && n > 0; i++) {
			if(fighters.get(i).canFire()) {
				fighters.get(i).fire();
				n--;
			}
		}
	}
	public boolean isFriendly() {
		return friendly;
	}
	public void turn() {
		for(int i = 0; i < fighters.size(); i++) {
			fighters.get(i).turn();
		}
	}
	public int repair(int n) {
		for(int i = 0; i < fighters.size() && n > 0; i++) {
			n = fighters.get(i).repair(n);
		}
		return n;
	}
}

