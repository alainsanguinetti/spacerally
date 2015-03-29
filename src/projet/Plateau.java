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
	public Plateau(Robot r1, Robot r2) {
		board = new ArrayList<Case>();
		positions = new ArrayList<Position>();
		creerBoard(r1,r2);
	}
	
	public void creerBoard(Robot r1, Robot r2) {
		int i,j;
		
		for(i=0;i<8;i++) {
			for(j=1;j<8;j++) {
				grid[i][j] = 0;
			}
		}
		
		coloquerDrapeaux();
		coloquerPuits();
		coloquerRobots();
		assignerCases(r1, r2);
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
		Random n = new Random();
		int i,j;
		int k=1;
		while(k<21){
			i = n.nextInt(8);
			j = n.nextInt(8);
			if( grid[i][j]==0) {
				grid[i][j] = 1;
				k++;
			}
		}
	}
	
	private void coloquerRobots() {
		int i, j=7, numRobots=0;
		while(numRobots<2) {
			for(i=0;i<8;i++) {
				if(numRobots==1) {
					if(i<7)
						i++;
					else {
						i=0;
						j--;
					}
				}			
				if(grid[j][i]==0) {
					if (i==0 && (grid[j][i+1]==0 || grid[j-1][i]==0) ) {
						grid[j][i] = 3;
						numRobots++;
					}
					else if (i==7 && (grid[j][i-1]==0 || grid[j-1][i]==0) && numRobots<2 ) {
						grid[j][i] = 3;
						numRobots++;
					}
					else if ((i!=0 && i!=7) && (grid[j][i-1]==0 || grid[j][i+1]==0 || grid[j-1][i]==0) && numRobots<2 ) {
						grid[j][i] = 3;
						numRobots++;
					}
				}
			}
			if(numRobots<2) 
				j--;
		}
	}
	
	private void assignerCases(Robot r1, Robot r2) {
		int i,j,rob=0;
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
				else if(grid[i][j] == 3) {
					if(rob==0) {
						r1.setPosition(p.getX(),p.getY());
						board.add(r1);
						rob++;
					}
					else {
						r2.setPosition(p.getX(),p.getY());
						board.add(r2);
					}
				}
			}
		}
	}
	
	public void afficherPlateau() {
		int i;
		String row = " ";
		for(i=0;i<64;i++) {
			row = row + board.get(i).toString() + "  ";
			if((i+1)%8 == 0) {
				System.out.println(row);
				row = " ";
			}
		}
	}
	
	public static void main(String[] args) {
		Position p = new Position(0,0);
		Robot r1 = new Robot(p);
		Robot r2 = new Robot(p);
		Plateau game = new Plateau(r1,r2);
		game.afficherPlateau();

	}
		
}