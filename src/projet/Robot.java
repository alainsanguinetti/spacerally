package projet;

import cartes.Carte;

public class Robot extends Case {

	/* *********ATTRIBUTS********* */
	/**
	 * Each robot has 3 lifes, which can be seen as oportunities to keep playing.
	 */
	private int vies;
	/**
	 * Each robot has an orientation in the board game described by a integer :
	 * 0 = north (nord)
	 * 1 = south (sud)
	 * 2 = east  (est)
	 * 3 = west  (ouest)
	 */
	private int orientation;
	/**
	 * A robot will execute an action in the game described by a card
	 */
	private Carte action;
	/**
	 * 
	 */
	private static int counter=1;
	/**
	 * 
	 */
	private int numeroRobot;
	
	/* *********GET/SET********* */
	public int getVies() {
		return this.vies;
	}
	
	public void setVies(int n) {
		this.vies = n;
	}
	
	public int getOrientation() {
		return this.orientation;	
	}
	
	public void setOrientation(int o) {
		this.orientation = o;
	}
	
	
	
	/* *********CONSTRUCTEUR********* */
	public Robot(Position p) {
		super(p);
		numeroRobot = counter;
		counter++;
		vies = 3;
	}
	
	/* *********METHODES********* */
	public void perdreVie() {
		this.vies--;
	}
	
	public String toString() {
		return "( R" + this.numeroRobot + ")";
	}
	
}
