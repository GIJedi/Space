package Weapon;
import java.util.ArrayList;

import FighterSquadron.FighterSquadron;
import Ships.Fighter;
import Ships.Ship;

public class Hanger {
	private ArrayList<FighterSquadron> squadrons;
	private int maxSize, maxRepair, repair;
	private Ship ship;
	
	public Hanger(int maxSize, int maxRepair, Ship ship) {
		this.maxSize = maxSize;
		this.maxRepair = maxRepair;
		this.repair = maxRepair;
		this.ship = ship;
		squadrons = new ArrayList<FighterSquadron>();
	}
	public void addSquadrons(FighterSquadron[] fighters) {
		for(int i = 0; i < fighters.length && !(this.squadrons.size() > maxSize); i++) {
			this.squadrons.add(fighters[i]);
		}
	}
	public void addSquadron(ArrayList<FighterSquadron> fighters) {
		for(int i = 0; i < fighters.size() && !(this.squadrons.size() > maxSize); i++) {
			this.squadrons.add(fighters.get(i));
		}
	}
	
	/**
	 * @todo test
	 */
	public void repairFighters() {
		for(int i = 0; (repair > 0) && (i < squadrons.size()); i++) {
			repair = squadrons.get(i).repair(repair);
		}
	}
	
}
