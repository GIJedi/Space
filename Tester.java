import java.io.PrintWriter;

import FighterSquadron.LaserFighterSquadron;
import Ships.BattleShip;
import Ships.MissileShip;
import Ships.Ship;
import Weapon.GatlingGun;
import sortAndSearch.Sort;

public class Tester {
	public static void main(String[] args) {
		BattleShip friendly = new BattleShip("Friendly", true);
		//MissileShip enemy = new MissileShip("Enemy", false);
		LaserFighterSquadron squadron = new LaserFighterSquadron("Test 1", 15, true);
		//PRE-TEST
		//System.out.println("Friendly\n" + friendly);
		System.out.println("Squadron\n" + squadron);
		System.out.println("Enemy\n" + friendly);
		
		//************* TEST GOES HERE ****************//
		System.out.println("----------------------START TEST----------------------");
		squadron.setPos(0, 1);
		squadron.setTarget(friendly);
		friendly.setTarget(squadron);
		while(!squadron.destroyed() && !friendly.destroyed()) {
			if(squadron.canFire()) {
				squadron.fireAll();
			}
			if(friendly.canFire() ) {
				friendly.fireAll();
			}
			squadron.turn();
			friendly.turn();
		}
		System.out.println("-----------------------END TEST-----------------------");
		//*********************************************//
		
		//POST-TEST
		//System.out.println("Friendly\n" + friendly);
		System.out.println("Squadron\n" + squadron);
		System.out.println("Enemy\n" + friendly);
		
	}
}
