package sortAndSearch;

import Ships.Ship;

public class Sort {
	public static void ship(Ship.ShipSort category, Ship[] ships, int min, int max) {
		if(max - min < 1) {
			return;
		}
		int mid = (max + min) / 2;
		
		ship(category, ships, min, mid);
		ship(category, ships, mid + 1, max);
		
		mergeShip(category, ships, min, mid, max);
	}
	private static void mergeShip(Ship.ShipSort category, Ship[] ships, int min, int mid, int max) {
		Ship[] temp = new Ship[max - min + 1];
		int i = min, j = mid + 1, n = 0;
		while(!(i > mid) || !(j > max)) {
			boolean condition = false;
			if(j != ships.length) {
				switch(category) {
				case NAME:
					condition = ships[i].name().compareTo(ships[j].name()) > 0;
					break;
				case HEALTH:
					condition =  ships[i].health() > ships[j].health();
					break;
				case STRENGTH:
					condition = ships[i].strength() > ships[j].strength();
					break;
				default:
					System.out.println("Sort error: improper condition");
					condition = true;
					break;
				}
			}
			if(i > mid) {
				temp[n] = ships[j];
				j++;
			}
			else if(j > max) {
				temp[n] = ships[i];
				i++;
			}
			else if(!condition) {
				temp[n] = ships[i];
				i++;
			}
			else {
				temp[n] = ships[j];
				j++;
			}
			n++;
		}
		
		for(int k = min; k <= max; k++) {
			ships[k] = temp[k - min];
		}
	}
}
