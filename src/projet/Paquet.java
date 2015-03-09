package projet;

import java.util.LinkedList;

/**
 * This class describes a deck of cards
 * @author alain
 *
 */
public class Paquet {
	
	private LinkedList<Carte> tas = new LinkedList<Carte>();

	public Paquet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates a standard deck of 84 cards
	 */
	private void creerCartes ()
	{
		//this.tas.creerCartesAvance();
		//this.tas.creerCartesTourner();
		//this.tas.ajouterCartesDemiTour();
	}
	
	/**
	 * Creates a new deck that contains i cards
	 * @param i
	 * @throws Exception 
	 */
	public Paquet(int i) throws Exception {
		
		if ( i != 84 )
		{
			// TODO renvoyer une exception
		}
		
		// pour chaque type de carte, créer toutes les cartes nécessaires
		//this.tas.creerCartes ();

		
	}

	/**
	 * Shuffles the card in the deck
	 */
	public void melanger() {
		// TODO Auto-generated method stub
		
	}

}
