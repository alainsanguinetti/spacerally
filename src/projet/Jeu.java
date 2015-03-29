package projet;

import graphique.InterfaceGraphique;
import cartes.Paquet;

/**
 * Cette classe est la classe mère du projet,
 * elle permet de lancer le moteur de jeu
 * et l'interface graphique
 * @author alain
 *
 */
public class Jeu {
	/*
	 * *** Attributs ***
	 */
	/**
	 * This is the deck of cards that we are going to play with.
	 */
	private Paquet pioche;
	/**
	 * Game engine to manage turns, collisions, etc.
	 */
	private MoteurDeJeu moteur;
	/**
	 * The board that will represent the game
	 */
	private Plateau plateau;
	private InterfaceGraphique interface_graphique;
	/**
	 * The players of the game.
	 */
	private Joueur j1;
	private Joueur j2;
	/**
	 * Boolean value to know if the game is over.
	 */
	private boolean fini;
	/*
	 * *** Getters and setters ***
	 */
	/**
	 * @return the state of fini.
	 */
	public boolean isFini() {
		return fini;
	}
	/**
	 * @param fini the state of fini to set
	 */
	public void setFini(boolean fini) {
		this.fini = fini;
	}
	/*
	 * *** Constructors ***
	 */
	/**
	 * Creates a game with two players.
	 */
	public Jeu ( )
	{
		// On prépare deux robots
		Position begin = new Position(0,0);
		Robot r1 = new Robot (begin);
		Robot r2 = new Robot (begin);
		// On invite les joueurs, ils choisissent un robot
		j1 = new Joueur ( r1 );
		j2 = new Joueur ( r2 );
		// On mélange les cartes
		pioche = new Paquet ( 84 );
		pioche.melanger();
		// On prépare un plateau de jeu
		plateau = new Plateau ( r1, r2 );
		// On prépare le moteur de jeu
		moteur = new MoteurDeJeu ( j1, j2, plateau, pioche );
		//on lance l'interface graphique
		interface_graphique = new InterfaceGraphique();
		// On initialise les variables
		setFini(false);
	}
	/*
	 * *** Functions ***
	 */
	private void tourDeJeu() {
		moteur.tourDeJeu();
		interface_graphique.rafraichir();
	}
	/*
	 * *** Main ***
	 */
	/**
	 * The function that will launch a game.
	 * @param arg
	 */
	public static void main ( String[] arg )
	{
		// Prepare a new game
		Jeu jeu = new Jeu ( );
		// On joue tant qu'on a pas fini
		while ( !jeu.isFini() )
			jeu.tourDeJeu();
		//
	}
}