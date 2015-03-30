package graphique;

import projet.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceGraphique extends JPanel{
	/*
	 * 		ATTRIBUTS
	 */

	private static final long serialVersionUID = 8111474601171204491L;
	/**
	 * On a un plateau qui define la distribution de tous les cases.
	 */
	private Plateau board;
	/**
	 * Pour l'affichage en ecran on a besoin d'un object de la classe JFrame.
	 */
	private JFrame window;
	/**
	 * Numero de vies du premier robot.
	 */
	private int viesR1;
	/**
	 * Numero de vies du deuxieme robot.
	 */
	private int viesR2;
	private Joueur j1;
	private Joueur j2;
	
	/*
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Chaque fois qu'on initialise une interface graphique on intialise aussi les parametres de la variable Window
	 * pour son affichage en ecran. 
	 * @param p, plateau genere par Moteur de Jeu
	 * @param v1, vies du premier robot
	 * @param v2, vies du deuxieme robot
	 */
	public InterfaceGraphique (Plateau p, Joueur j1, Joueur j2){
		board = p;
		this.j1 = j1;
		this.j2 = j2;
		viesR1 = this.j1.getRob().getVies();
		viesR2 = this.j2.getRob().getVies();
		window = new JFrame("ROBORALLY");
		window.setSize(1900, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(this);
		window.setVisible(true);
	}
	
	/**
	 * Cette fonction va dessiner les components de l'interface: cases, joeurs et ses donnes (numero de vies
	 * et drapeaux, ainsi comme leur identifiant).
	 */
	public void paintComponent(Graphics ig) {
		Font ecrit = new Font("Consolas",Font.BOLD,18);
		ig.setFont(ecrit);
		ig.setColor(Color.blue);
		int i,j,k=0;
		//On dessine les cases
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				ig.drawImage(board.getBoard().get(k).getImage(),50+j*90,50+i*90,90,90,this);
				k++;
			}
		}
		//On dessine les infos de joeurs
		try {
			ig.drawString("Joueur 1", 60, 930);
			ig.drawImage(ImageIO.read(new File("img/player/r1.png")), 50, 820, 90, 90, this);
			for(i=0;i<viesR1;i++) {
				ig.drawImage(ImageIO.read(new File("img/player/1up.png")), 150+i*30, 820, 30, 30, this);
			}
			ig.drawString("Joueur 2", 420, 930);
			ig.drawImage(ImageIO.read(new File("img/player/r2.png")), 410, 820, 90, 90, this);
			for(i=0;i<viesR2;i++) {
				ig.drawImage(ImageIO.read(new File("img/player/1up.png")), 510+i*30, 820, 30, 30, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Mettre a jour l'affichage graphique.
	 */
	public void rafraichir() {
		window.repaint();
	}
	
	/*
	public static void main(String[] args) {
		Position p = new Position(0,0);
		Robot r1 = new Robot(p);
		Robot r2 = new Robot(p);
		Plateau game = new Plateau(r1,r2);
		InterfaceGraphique g = new InterfaceGraphique(game);
		game.afficherPlateau();
		
		g.rafraichir();
	} */
	
	

}
