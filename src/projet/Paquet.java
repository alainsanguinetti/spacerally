package projet;

import java.util.LinkedList;

import cartes.*;

/**
 * This class describes a deck of cards
 * @author alain
 *
 */
public class Paquet {
	
	private LinkedList<Carte> tas = new LinkedList<Carte>();
	
	/**
	 * Creates a new deck that contains i cards
	 * @param i
	 */
	public Paquet() {
		
		tas.addAll( Deplacement.cartes( 18, 1 ) );
		tas.addAll( Deplacement.cartes( 12, 2 ) );
		tas.addAll( Deplacement.cartes( 6, 3 ) );
		tas.addAll( Deplacement.cartes( 6, 1 ) );
		tas.addAll( Orientation.cartes( 18, 1 ) );
		tas.addAll( Orientation.cartes( 18, -1 ) );
		tas.addAll( Orientation.cartes( 6, 2 ) );

		
	}

	/**
	 * Shuffles the card in the deck
	 */
	public void melanger() {
		// TODO Auto-generated method stub
		
	}

}
