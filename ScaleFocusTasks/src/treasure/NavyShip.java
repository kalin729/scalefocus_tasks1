package treasure;

import java.util.Random;

public class NavyShip {
	
	Random r = new Random();
	private int X;
	private int Y;
	String direction;
	
	
	NavyShip(int getMaxY, int getX){
		this.Y = Math.abs((r.nextInt()%2)*(
				getMaxY-1));
		if(this.Y == 0) {
			this.Y = 0;
		}else if(this.Y == getMaxY-1) {
			this.Y -= 0;
		}
		this.X = getX;
		if(this.Y==getMaxY-1) {direction="up";}else {direction="down";}
	}
	
	public int move(int step, int maxY) {
		
		if(this.Y+step>=maxY-1) {
			this.direction="up";
		}
		
		if(this.Y-step<1) {
			this.direction="down";
		}
		
		if(this.direction=="down") {
			this.Y+=step;
		}else {
			this.Y-=step;
		}
		
		return Y;
		
	}
	
	public int nextMove(int maxY) {
		if(this.Y+1==maxY) {
			return this.Y-1;
		}
		if(this.Y-1==-1) {
			return this.Y+1;
		}
		
		if(this.direction=="down") {
			return this.Y+1;
		}else {
			return this.Y-1;
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "N";
	}
	
}
