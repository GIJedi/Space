package FighterSquadron;

import Ships.LaserFighter;

public class LaserFighterSquadron extends FighterSquadron{
	private static final String type = "Laser Fighter Squadron";
	
	public LaserFighterSquadron(String name, int maxSize, boolean friendly) {
		super(type, name, maxSize, LaserFighter.evasiveness(1), friendly);
		intialize();
	}
	private void intialize() {
		for(int i = 0; i < maxSize(); i++) {
			addFighter(new LaserFighter(friendly()));
		}
		calcStrength();
	}
	@Override
	public String toString() {
		return String.format("%15s %4d %4d %6s%6s%n", name(), strength(), currentSize(),  isFriendly(), destroyed());
	}
}
