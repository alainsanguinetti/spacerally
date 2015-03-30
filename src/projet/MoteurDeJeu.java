package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import cartes.Action;
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
	private LinkedList<Action> pile = new LinkedList<Action>();
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
	
	
	private void effectuer(LinkedList<Action> pile2) {
		// TODO Auto-generated method stub
		
	}
	
	private LinkedList<Action> listerActions(Joueur j1, Joueur j2) {
		
		int v1, v2, i1, i2; 
		
		i1 = 0;
		i2 = 0;
		
		LinkedList<Action> resultat = new LinkedList<Action>();
		
		do {
			// On lit la vitesse du J1 et du J2
			v1 = ( j1.getChoix()[i1] != null ) ? j1.getChoix()[i1].getVitesse() : -1;
			v2 = ( j2.getChoix()[i1] != null ) ? j2.getChoix()[i2].getVitesse() : -1;;
				
			// On ajoute le plus grand à la pile d'action
			if ( v1 > v2 )
			{
				resultat.add( new Action (j1.getChoix()[i1], j1) );
				j1.getChoix()[i1] = null;
				i1++;
			}
			else 
			{
				resultat.add( new Action (j2.getChoix()[i2], j2) );
				j2.getChoix()[i2] = null;
				i2++;
			}
			// On recommence jusqu'à ce que les 2 soient vides
		}while ( ( v1!=-1 || v2 !=-1 ) && ( i1 < 5 ) && ( i2 < 5 ) );
		
		return resultat;
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
		// Liste des actions
		pile = listerActions ( j1, j2 );
		
		// Effectuer les actions
		effectuer ( pile );
	}


}
