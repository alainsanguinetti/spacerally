package projet;

import java.util.ArrayList;
import java.util.Random;

public class Plateau {
	
	/*
	 * 		ATTRIBUTS
	 */
	/**
	 * On aura une collection de Cases qui va conformer le plateau.
	 */
	private ArrayList<Case> board;
	/**
	 * Comme chaque Case a une position, on aura aussi une collection de Positions.
	 */
	private ArrayList<Position> positions;
	/**
	 * Pour afficher le tableau en maniere de grille, on aura une matrice bidimensionnelle de numeros entiers.
	 */
	int[][] grid = new int[8][8];
	
	/*
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Quand on cree un Plateau il faut le donner deux robots. Au meme temps on initialise les deux ArrayList et on
	 * appel la fonction creerBoard.
	 * @param r1
	 * @param r2
	 */
	public Plateau(Robot r1, Robot r2) {
		board = new ArrayList<Case>();
		positions = new ArrayList<Position>();
		creerBoard(r1,r2);
	}
	
	/*
	 * 		GETTERS/SETTERS
	 */
	/**
	 * On obtient le Plateau.
	 * @return la collection de cases ou plateau.
	 */
	public ArrayList<Case> getBoard() {
		return this.board;
	}
	/**
	 * On obtient la matrice ou grille.
	 * @return la grille.
	 */
	public int[][] getGrid() {
		return this.grid;
	}
	
	/*
	 * 		METHODES
	 */
	/**
	 * Ici on rempli la grille en repartant les drapeaux, robots et puits. D'abord on donne de Cases vides a toute la grille.
	 * Pour ca on utilise les differentes valeurs pour la variable grid:
	 *  grid[i][j] = 0 -> Case vide
	 *  grid[i][j] = 1 -> Puits
	 *  grid[i][j] = 2 -> Drapeau
	 *  grid[i][j] = 3 -> Robot
	 *  Apres on coloque les drapeaux, puits et robots en appelant leurs fonctions et dernierement on rempli l'ArrayList de
	 *  Cases en utilisant la grid.
	 * @param r1
	 * @param r2
	 */
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
	/**
	 * On divide le plateau en 4 parties, et on pose un drapeau aleatoirement dans chaque partie. 
	 */
	private void coloquerDrapeaux() {
		Random i = new Random();
		Random j = new Random();
		
		grid[i.nextInt(4)][j.nextInt(4)] = 2;
		grid[i.nextInt(4)+4][j.nextInt(4)] = 2;
		grid[i.nextInt(4)][j.nextInt(4)+4] = 2;
		grid[i.nextInt(4)+4][j.nextInt(4)+4] = 2;
	}
	/**
	 * Les 2 puits on les coloque de maniere aletoire par tout la grille. D'abord on verifie que la casse
	 * ou on veut le poser est vide, sinon on cherche une autre case.
	 */
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
	/**
	 * Pour commencer le jeu on coloque les 2 robots dans la derniere ligne (de cette facon ils sont loin de le premier
	 * drapeau. D'abord on verifie que la case ou on veut poser le robot est vide. Apres on verifie que le robot aura au moins
	 * un case vide soit a droite, a gauche ou en face. Pour ne poser pas les deux robots cote a cote on laisse toujours au 
	 * moins un espace entre les deux. Si on a fini de chercher cases vides et qui satisfont les caracteristiques mentionnes
	 * on passe a la avant-derniere ligne.
	 */
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
	/**
	 * Un foit qu'on a rempli le grille (variable grid) on va associer des vrais Cases et pas seulement une valeur entiere.
	 * On a besoin des deux robots pour mettre a jour leurs positions. On parcourt la matrice grid et selon sa valeur
	 * on ajoute le type de case correspondant a la variable board (ArrayList<Case>).
	 * @param r1
	 * @param r2
	 */
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
	/**
	 * Pour afficher le Plateau dans une terminal on parcourt la variable board qui est compose des objets type Case
	 * ou des classes enfant qui ont la methode toString(). Pour l'afficher comme un grille de 8x8 on saute de ligne
	 * chaque fois que la variable i est un multiple de 8.
	 */
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
	/*
	public static void main(String[] args) {
		Position p = new Position(0,0);
		Robot r1 = new Robot(p);
		Robot r2 = new Robot(p);
		Plateau game = new Plateau(r1,r2);
		game.afficherPlateau();

	} */
	
	/**
	 * Get the case that is at x, y of the board
	 * @param posi_case x and y as a Position object
	 * @return the Case at index x and y
	 */
	public Case getCase ( Position posi_case )
	{
		return board.get( posi_case.getX() + posi_case.getY() * 8 );
	}

	/**
	 * Set the case at index x,y of the board
	 * @param posi_case, the position of the new Case
	 * @param case1 the new Case
	 */
	public void setCase(Position posi_case, Case case1) {
		// TODO Auto-generated method stub
		
	}
		
}