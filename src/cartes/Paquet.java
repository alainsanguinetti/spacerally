package cartes;

import java.util.LinkedList;
import java.util.Random;

/**
 * This class describes a deck of cards
 * @author alain
 *
 */
public class Paquet {
	
	Random r = new Random ( ) ;
	/**
	 * A deck of cards
	 */
	private LinkedList<Carte> tas = new LinkedList<Carte>();
	
	/**
	 * Default constructor
	 */
	public Paquet ( )
	{
		
	}
	
	/**
	 * Creates a new deck that contains i cards
	 * @param i
	 */
	public Paquet( int nb ) {
		
		tas.addAll( Deplacement.cartes( 18, 1 ) );
		tas.addAll( Deplacement.cartes( 12, 2 ) );
		tas.addAll( Deplacement.cartes( 6, 3 ) );
		tas.addAll( Deplacement.cartes( 6, 1 ) );
		tas.addAll( Orientation.cartes( 18, 1 ) );
		tas.addAll( Orientation.cartes( 18, -1 ) );
		tas.addAll( Orientation.cartes( 6, 2 ) );
		
	}

	/**
	 * @return the tas
	 */
	public LinkedList<Carte> getTas() {
		return tas;
	}

	/**
	 * @param tas the tas to set
	 */
	public void setTas(LinkedList<Carte> tas) {
		this.tas = tas;
	}

	/**
	 * Shuffles the card in the deck
	 */
	public void melanger() {
		int limite = 100;
		int index = 0;
		
		for ( int i = 0; i < limite; i++ )
		{
			index = r.nextInt(this.getTas().size());
			Carte carte = this.getTas().get(index);
			this.getTas().remove(index);
			this.getTas().add(carte);
		}
	}
	
	/**
	 * Add a new card
	 * @param carte
	 */
	public void add ( Carte carte ){
		tas.add(carte);
	}
	
	/**
	 * Retrieves the card at index index from the deck
	 * @param index
	 * @return the card
	 */
	public Carte get ( int index ){
		return tas.get(index);
	}

	/**
	 * Returns the number of card in a deck.
	 * @return the number of cards
	 */
	public int size() {
		return tas.size();
	}

	/**
	 * Get the first nb cartes of a deck
	 * @param nb the number of cards wished
	 * @return
	 */
	public Paquet tirerCartes(int nb) {
		int i = 0;
		Paquet main = new Paquet ( );
		
		// Tant qu'il y a assez de cartes dans le paquet, on tire une carte jusqu'à ce qu'on en ait assez
		while ( tas.size() != 0 && i < nb )
		{
			main.add ( tas.get(0) );
			i++;
		}
		
		return main;
	}

}
