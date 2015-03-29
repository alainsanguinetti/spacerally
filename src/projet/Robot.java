package projet;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cartes.Carte;

public class Robot extends Case {

	/* *********ATTRIBUTS********* */
	/**
	 * Each robot has 3 lifes, which can be seen as oportunities to keep playing.
	 */
	private int vies;
	/**
	 * Each robot has an orientation in the board game described by a integer (degrees :
	 * 90 = north (nord)
	 * 270 = south (sud)
	 * 180 = east  (est)
	 * 0 = west  (ouest)
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
	
	public void setRobotImage() {
		try {
			if(this.numeroRobot==1) {
				switch(this.orientation) {
				case 90: this.img = ImageIO.read(new File("img/robots/r1_0.png"));
						break;
				case 270: this.img = ImageIO.read(new File("img/robots/r1_1.png"));
						break;
				case 180: this.img = ImageIO.read(new File("img/robots/r1_2.png"));
						break;
				case 0: this.img = ImageIO.read(new File("img/robots/r1_3.png"));
						break;
				default: break;
				}
			}
			else if(this.numeroRobot==2) {
				switch(this.orientation) {
				case 90: this.img = ImageIO.read(new File("img/robots/r2_0.png"));
						break;
				case 270: this.img = ImageIO.read(new File("img/robots/r2_1.png"));
						break;
				case 180: this.img = ImageIO.read(new File("img/robots/r2_2.png"));
						break;
				case 0: this.img = ImageIO.read(new File("img/robots/r2_3.png"));
						break;
				default: break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/* *********CONSTRUCTEUR********* */
	public Robot(Position p) {
		super(p);
		numeroRobot = counter;
		counter++;
		vies = 3;
		orientation = 90;
		try {
			switch(numeroRobot) {
			case 1: this.img = ImageIO.read(new File("img/robots/r1_0.png"));
					break;
			case 2: this.img = ImageIO.read(new File("img/robots/r2_0.png"));
					break;
			default: break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* *********METHODES********* */
	public void perdreVie() {
		this.vies--;
	}
	
	public String toString() {
		return "( R" + this.numeroRobot + ")";
	}
	
}
