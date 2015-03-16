package projet;

import java.util.LinkedList;

/**
 * Cette classe est la classe mère du projet, 
 * elle permet de lancer le moteur de jeu
 * et l'interface graphique
 * @author alain
 *
 */
public class Jeu {
	
	/*
	 *           *** Attributs ***
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
	//private InterfaceGraphique hmi;
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
	 *           *** Getters and setters ***
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
	 *           *** Constructors ***
	 */
	/**
	 * Creates a game with two players.
	 */
	public Jeu ( )
	{
		// On prépare deux robots
		Robot r1 = new Robot ();
		Robot r2 = new Robot ();
		
		// On invite les joueurs, ils choisissent un robot
		j1 = new Joueur ( r1 );
		j2 = new Joueur ( r2 );
		
		// On mélange les cartes
		pioche = new Paquet ( );
		pioche.melanger();
		
		// On prépare un plateau de jeu
		plateau = new Plateau ( r1, r2 );
	}
	/**
	 * Creates a game with two players
	 * @param j1
	 * @param j2
	 * @param plateau 
	 * @param pioche 
	 */
	public Jeu(Joueur j1, Joueur j2, Paquet pioche, Plateau plateau ) {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *           *** Functions ***
	 */
	
	/*
	 *           *** Main ***
	 */
	/**
	 * The function that will launch a game.
	 * @param arg
	 */
	public static void main ( String[] arg )
	{
		// Prepare a new game
		Jeu jeu = new Jeu ( );
	}

}
