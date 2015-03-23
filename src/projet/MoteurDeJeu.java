package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cartes.Paquet;

/**
 * This class is the engine of the game
 * @author alain
 *
 */
public class MoteurDeJeu {
	
	/*
	 *            *** Attributs ***
	 */
	private Joueur j1;
	private Joueur j2;
	private Plateau plateau;
	private Paquet pioche;
	private int gagnant = 0;
	/*
	 *            *** Accesseurs ***
	 */
	/**
	 * Function to know who is the winner
	 * @return the number of the player who won
	 */
	public int getGagnant() {
		return gagnant;
	}
	/*
	 *           *** Constructeurs ***
	 */
	public MoteurDeJeu(Joueur j1, Joueur j2, Plateau plateau, Paquet pioche ) {
		
		this.j1 = j1;
		this.j2 = j2;
		this.plateau = plateau;
		this.pioche = pioche;
		gagnant = 0;
	}
	
	/**
	 * Default, empty constructor
	 */
	public MoteurDeJeu() {
		
	}
	/*
	 *           *** Fonctions ***
	 */
	/**
	 * Ask the user for a confirmation
	 * @param string
	 * @return true if the user confirms
	 */
	public boolean confirm(String string) {
		
		boolean compris = false;
		
		// Lecture du flux d'entrée
		String inputData = "";
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

		// Affichage du menu
		System.out.println(string);
		System.out.println("O : oui, N : non, Q : quitter le jeu" );
		
		// Lecture du choix
		while ( !compris )
		{
			try { 
				inputData = inputReader.readLine();
			} catch(IOException e) { System.out.println("Error reading keyboard input"); }
			
			switch ( inputData ){
				case "O":
					compris = true;
					return true;
				case "N":
					compris = true;
					return false;
				default :
					compris = false;
			}
		}
		
		return false;
		
		
	}
	/**
	 * Handles playing one turn of the game
	 */
	public void tourDeJeu() {
		// J1 prépare son jeu
		if( confirm ( "Le joueur 1 va jouer" ) )
			j1.preparerJeu( pioche.tirerCartes( 9 ) );
		
		// J2 prépare son jeu
		if ( confirm ( "Le joueur 2 va jouer" ) )
			j2.preparerJeu ( pioche.tirerCartes ( 9 ) );
		
		// On effectue les déplacements
		
	}


}
