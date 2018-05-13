package Interfaces;

public interface Coordinate {
	abstract int xPos();
	abstract int yPos();
	abstract void setX(int i);
	abstract void setY(int i);
	abstract void setPos(int x, int y);
	abstract void addX(int i);
	abstract void addY(int i);
	double calcDistance(Coordinate c);
	double calcDistance(int x, int y);
}
