package treasure;

import java.util.Random;

public class PirateShip {

	Random r = new Random();
	int X = 1;
	int Y;
	
	PirateShip(int getMaxY){
		this.Y = r.nextInt(getMaxY);
		if(this.Y == 0) {
			this.Y = 1;
		}else if(this.Y == getMaxY-1) {
			this.Y -= 1;
		}
	}
	
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "X";
	}
	
}
