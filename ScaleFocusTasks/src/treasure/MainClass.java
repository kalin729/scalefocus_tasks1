package treasure;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

	static Scanner in = new Scanner(System.in);
	static int maxY;
	static int maxX;
	Random r = new Random();
	static PirateShip pl = null;
	static ArrayList<NavyShip> ns = new ArrayList<NavyShip>();
	static char[][] map = null;
	static int step = 0;
	
	public static void main(String[] args) {
		
			System.out.println("Enter Y: ");
			maxY = in.nextInt()+2;
			System.out.println("Enter X: ");
			maxX = in.nextInt()+2;
			pl = new PirateShip(maxY);
			map = new char[maxY][maxX];
			
			setShips();
	        
			System.out.println("Pass? " + Pass(pl.getX(), pl.getY()));

	}
	
	private static boolean Pass(int xPos, int yPos) {
		
		boolean canMoveBool = false;
		
		for(int i = xPos; i < maxX-1; i++) {
			visualiseMap();
			canMoveBool =  canMove(xPos, yPos+1)
					&& canMove(xPos, yPos-1)
					&& canMove(xPos-1, yPos)
					&& canMove(xPos+1, yPos)
					&& canMove(xPos-1, yPos-1)
					&& canMove(xPos+1, yPos-1)
					&& canMove(xPos-1, yPos+1)
					&& canMove(xPos+1, yPos+1);
			

			step = 1;
			xPos++;
			pl.setX(xPos);
			
			if(!canMoveBool) {
				return false;
			}
		}
		
		
		
		return true;
	}
	
	private static boolean canMove(int xPos, int yPos) {

		if(map[yPos][xPos] == (char) 'N') {
			return false;
		}
		
		return true;
	}
	
	private static void visualiseMap() {
		
		step = 1;
		
		System.out.println("Turn: " + (pl.getX()));
		
		 for (int row = 1; row < maxY-1; row ++) {
	            for (int col = 1; col < maxX-1; col++) {
	            	map[row][col] = (char) ('0');
	            }
		 }
		 map[pl.getY()][pl.getX()] = (char) 'X';
			
		 	for(NavyShip each : ns) {
				each.move(step, maxY);
				map[each.getY()][each.getX()] = (char) ('N');
			}
		 
	        for (int row = 0; row < maxY; row ++) {
	            for (int col = 0; col < maxX; col++) {
	                System.out.print (map[row][col] + " ");
	            }
	            System.out.println();
	        }
	        System.out.println();
		
	}
	
	private static void setShips() {
		map[pl.getY()][pl.getX()] = (char) 'X';
		
		for (int i = 2; i < maxX-2; i++) {
			ns.add(new NavyShip(maxY, i));
		}
	}

}
