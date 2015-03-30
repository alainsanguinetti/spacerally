package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import cartes.Action;
import cartes.Carte;
import cartes.Deplacement;
import cartes.Orientation;
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
	
	/**
	 * Performs cleaning action that corresponds to one of the robot being dead
	 * @param j the player whose robot is dead
	 */
	private void joueurMort(Joueur j) {
		// Enlever une vie au joueur
		j.getRob().perdreVie();
		
		// Vider la pile des actions correspondantes
		for ( int i = 0; i < pile.size(); i++ )
		{
			if ( pile.get(i).getJ() == j )
			{
				pile.remove(i);
			}
		}
	}
	
	/**
	 * Move robot from one position to the other on the board
	 * @param posi_now
	 * @param posi_future
	 */
	private void bougerRobot(Position posi_now, Position posi_future) {
		Case temp = plateau.getCase(posi_future);
		plateau.setCase ( posi_future, plateau.getCase(posi_now));
		plateau.setCase ( posi_now, temp );		
	}
	
	/**
	 * Move the robot of a player
	 * @param j the player 
	 * @param param the number of Case(s)
	 */
	private void deplacer(Joueur j, int param) {
		
		// Position actuelle
		Position posi_now = j.getRob().getPosition();
		Position dep_x_y = j.getRob().getOrientationAsPosi();
		Position posi_future = posi_now;
		
		// Tests des positions suivantes
		for ( int i = 1; i <= param; i++ )
		{
			posi_future = new Position (
					posi_now.getX() + i * dep_x_y.getX(),
					posi_now.getY() + i * dep_x_y.getY() );
			
			// Si il y a un robot
			if ( plateau.getCase(posi_future).getClass() == Robot.class )
			{
				deplacer ( ( j == j1 ) ? j2 : j1, 1 );
			}
			// Si c'est un puit
			else if ( plateau.getCase(posi_future).getClass() == Puits.class )
			{
				joueurMort ( j );
				return;
			}
			// Si c'est un drapeau
			else if ( plateau.getCase(posi_future).getClass() == Drapeau.class )
			{
				j.setNbrDrapeaux(
						j.getNbrDrapeaux() + 
						( ( Drapeau ) plateau.getCase(posi_future)).numDrapeau );
				
				// Si on a gagné
			}
		}
		
		bougerRobot ( posi_now, posi_future );
		
	}
	
	/**
	 * Performs the set of instructions described by pile
	 * @param pile2 the set of instructions
	 */
	private void effectuer(LinkedList<Action> pile2) {
		
		Action action;
		
		// Tant qu'il y a des actions, 
		while ( pile2.size() > 0 )
		{
			// Executer l'action
			action = pile2.get(0);
			
			// Déplacement
			if ( action.getMvt().getClass() == Deplacement.class )
			{
				deplacer ( action.getJ(), action.getMvt().getParam() );
			}
			// Changement d'orientation
			else if ( action.getMvt().getClass() == Orientation.class )
			{
				//tourner ( action.getJ(), action.getMvt().getParam() );
			}

			
			// Résurection d'un joueur
			pile2.remove(0);
		}
		
	}	

	/**
	 * Creates a set of actions that the game engine will perform
	 * @param j1 the first player
	 * @param j2 the second player
	 * @return Actions, ordered in the correct way
	 */
	private LinkedList<Action> listerActions(Joueur j1, Joueur j2) {
		
		int v1, v2, i1, i2; 
		
		i1 = 0;
		i2 = 0;
		
		LinkedList<Action> resultat = new LinkedList<Action>();
		
		do {
			// On lit la vitesse du J1 et du J2
			v1 = ( j1.getChoix()[i1] != null ) ? j1.getChoix()[i1].getVitesse() : -1;
			v2 = ( j2.getChoix()[i2] != null ) ? j2.getChoix()[i2].getVitesse() : -1;;
				
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
