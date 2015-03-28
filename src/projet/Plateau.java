package projet;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	
	/*
	 * ATTRIBUTS
	 */
	private ArrayList<Case> board;
	private ArrayList<Position> positions;
	int[][] grid = new int[8][8];
	
	/*
	 * CONSTRUCTEUR
	 */
	public Plateau() {
		board = new ArrayList<Case>();
		positions = new ArrayList<Position>();
		
	}
	
	public void creerBoard() {
		int i,j;
		
		for(i=0;i<8;i++) {
			for(j=1;j<8;j++) {
				grid[i][j] = 0;
			}
		}
		
		coloquerDrapeaux();
		coloquerPuits();
		assignerCases();
		
	}
	
	private void coloquerDrapeaux() {
		Random i = new Random();
		Random j = new Random();
		
		grid[i.nextInt(4)][j.nextInt(4)] = 2;
		grid[i.nextInt(4)+4][j.nextInt(4)] = 2;
		grid[i.nextInt(4)][j.nextInt(4)+4] = 2;
		grid[i.nextInt(4)+4][j.nextInt(4)+4] = 2;
	}
	
	private void coloquerPuits() {
		
	}
	
	private void assignerCases() {
		int i,j;
		Position p;
		Case c;
		Puits pu;
		Drapeau d;
		
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				p = new Position(i,j);
				positions.add(p);
				if (grid[i][j] == 0) {
					c = new Case(p);
					board.add(c);
				}
				else if(grid[i][j] == 1) {
					pu = new Puits(p);
					board.add(pu);
				}
				else if(grid[i][j] == 2) {
					d = new Drapeau(p);
					board.add(d);
				}
			}
		}
	}
	
	
}