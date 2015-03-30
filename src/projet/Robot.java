package projet;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cartes.Carte;

public class Robot extends Case {

	/*
	 *  		ATTRIBUTS
	 */
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
	 * Variable pour gerer l'assignation de la variable numeroRobot.
	 */
	private static int counter=1;
	/**
	 * Chaque robot a un numero associe, 1 ou 2, qui corresponde aussi au numero de joueur.
	 */
	private int numeroRobot;
	
	/*		
	 * GETTERS/SETTERS
	 */
	/**
	 * On obtient le numero de vies du robot.
	 * @return le numero de vies du robot.
	 */
	public int getVies() {
		return this.vies;
	}
	/**
	 * On modifie le numero de vies du rubot.
	 * @param n, qui corresponde au nouveau numero de vies.
	 */
	public void setVies(int n) {
		this.vies = n;
	}
	/**
	 * On obtient l'orientation du robot.
	 * @return un integer qui corresponde a l'orientation du robot.
	 */
	public int getOrientation() {
		return this.orientation;	
	}
	/**
	 * On modifie l'orientation du robot.
	 * @param o, la nouvelle orientation du robot.
	 */
	public void setOrientation(int o) {
		this.orientation = o;
	}
	/**
	 * On modifie l'image du Robot. Chaque robot a une image differente pour chaque orientation.
	 */
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
	
	/* 
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Chaque fois qu'on cree un objet Robot on le donne une position, un numero de robot selon la variable counter et
	 * pour l'initialiser on le donne 3 vois et une orientation vers le nord, et les images correspondantes.
	 * @param p, position initiale.
	 */
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
	
	/*		
	 * 		METHODES
	 */
	/**
	 * Chaque fois que le robot tombe sur une case Puits il perdre une vie.
	 */
	public void perdreVie() {
		this.vies--;
	}
	/**
	 * On associe un String au Robot pour un affichage en terminal.
	 */
	@Override
	public String toString() {
		return "( R" + this.numeroRobot + ")";
	}
	
}
