package Ships;

import Interfaces.Coordinate;
import Interfaces.Targetable;
import Weapon.Projectile;

public abstract class Ship implements Targetable{
	private int speed, remainingSpeed, evasiveness, health, maxHealth, x, y, strength, shield, shieldRenewRate, maxShield ;
	private boolean friendly, destroyed;
	protected Targetable target = null;
	private String name, type;
	public Ship(String type, String name, int evasiveness, int health, int shield, int shieldRenewRate, int speed, int x, int y, boolean friendly) {
		this.type = type;
		this.name = name;
		this.evasiveness = evasiveness;
		this.health = health;
		this.maxHealth = health;
		this.maxShield = shield;
		this.shieldRenewRate = shieldRenewRate;
		this.shield = shield;
		this.x = x;
		this.y = y;
		this.friendly = friendly;
		calcStrength(health);
	}
	public static enum ShipSort {
		NAME,
		HEALTH,
		STRENGTH,
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
	public void addX(int i) {
		x += i;
	}
	@Override
	public void addY(int i) {
		y += i;
	}
	@Override
	public void shoot(Projectile p) {
		if(p.checkHit()) {
			//System.out.println("Hit");
			damage(p.damage());
		}
		else {
			//System.out.println("Miss");
		}
	}
	public double calcDistance(Coordinate c) {
		return Math.sqrt(Math.pow(c.xPos() - x, 2) + Math.pow(c.yPos() - y, 2));
	}
	public double calcDistance(int x, int y) {
		return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
		
	}
	public void move(int x, int y) {
		if(calcDistance(x, y) > remainingSpeed) {
			System.out.println("Cannot move, too far");
		}
		else {
			this.x = x;
			this.y = y;
			remainingSpeed -=(int)(calcDistance(x, y));
		}
	}
	public boolean isFriendly() {
		return friendly;
	}
	public void friendly(boolean b) {
		this.friendly = b;
	}
	public int health() {
		return health;
	}
	public Targetable getTarget() {
		return target;
	}
	public abstract void setTarget(Targetable target);
	public boolean destroyed() {
		return destroyed;
	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String name() {
		return name;
	}
	public int evasiveness() {
		return evasiveness;
	}
	public int strength() {
		return strength;
	}
	
	public int shield() {
		return shield;
	}
	public int getMaxShield() {
		return maxShield;
	}
	public void damage(int i) {
		shield -= i;
		if(shield <= 0) {
			i = -shield;
			shield = 0;
			health -= i;
			if(health <= 0) {
				destroyed = true;
			}
		}
	}
	public void damageShieldOnly(int damage) {
		this.shield -= damage;
		if(shield <= 0) {
			shield = 0;
		}
	}

	/**
	 * 
	 * @param i		repair health value
	 * @return		leftover of i
	 */
	public int repair(int i) {
		this.health += i;
		if(health > maxHealth) {
			i = health - maxHealth;
			health = maxHealth;
			return i;
		}
		return 0;
	}/**
	 * 
	 * @param ships		array of all enemy ships
	 * @param target	target type
	 */
	public void findTarget(Ship[] ships, Target target) {
		Ship currentTarget = ships[0];
		double value = -1;
		switch(target) {
		case CLOSEST:
			value = calcDistance(ships[0]);
			break;
		case STRONGEST:
			value = ships[0].strength();
			break;
		case MOST_HEALTH:
			value = ships[0].health();
			break;
		}
		
		for(int i = 0; i < ships.length; i++) {
			double t = -1;
			switch(target) {
			case CLOSEST:
				t = this.calcDistance(currentTarget);
				if(t > value) {
					currentTarget = ships[i];
				}
				break;
			case STRONGEST:
				t = ships[i].strength();
				if(t > value) {
					currentTarget = ships[i];
				}
				break;
			case MOST_HEALTH:
				t = ships[i].health();
				if(t > value) {
					currentTarget = ships[i];
				}
				break;
			default :
				currentTarget = null;
				break;
			}
		}
	}
	public int maxHealth() {
		return maxHealth;
	}
	public String type() {
		return type;
	}
	public int speed() {
		return speed;
	}
	public void resetSpeed() {
		this.remainingSpeed = speed;
	}
	public void chargeShield() {
		this.shield+= shieldRenewRate;
		if(shield > maxShield) {
			shield = maxShield;
		}
		
	}
	protected void setStrength(int i) {
		this.strength = i;
	}
	public abstract void turn();
	protected abstract void calcStrength(int health);
	
}
