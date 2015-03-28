package projet;

import cartes.Carte;

public class Robot {

	/* *********ATTRIBUTS********* */
	/**
	 * Each robot has 3 lifes, which can be seen as oportunities to keep playing.
	 */
	private int vies;
	/**
	 * Each robot has an orientation in the board game
	 */
	private String orientation;
	/**
	 * 
	 */
	private Position pos;
	/**
	 * A robot will execute an action in the game described by a card
	 */
	private Carte action;
	
	/* *********GET/SET********* */
	public int getVies() {
		return this.vies;
	}
	
	public void setVies(int n) {
		this.vies = n;
	}
	
	public String getOrientation() {
		return this.orientation;	
	}
	
	public void setOrientation(String o) {
		this.orientation = o;
	}
	
	public Position getRobotPos() {
		return this.pos;
	}
	
	public void setRobotPos(Position p) {
		this.pos.setPos(p.getX(),p.getY());
	}
	
	
	/* *********CONSTRUCTEUR********* */
	public Robot() {
		
	}
	
	/* *********METHODES********* */
	public void perdreVie() {
		this.vies--;
	}
	
}
