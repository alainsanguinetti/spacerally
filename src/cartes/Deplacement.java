package cartes;

import java.util.LinkedList;

/**
 * This is a type of card that do not change orientation of the robot
 * but will change its position on the game 
 * @author alain
 *
 */
public class Deplacement extends Carte {

	/*
	 *            *** Attributes ***
	 */
	
	/*
	 *            *** Getters and Setters ***
	 */

	/*
	 *            *** Constructor *** 
	 */
	public Deplacement( int distance ) {
		
		setParam ( distance );
	}
	
	/*
	 *            *** functions ***
	 */
	public static LinkedList<Carte> cartes ( int nb, int arg ) {
		
		LinkedList<Carte> temp = new LinkedList<Carte>();
		
		for ( int i = 0; i < nb; i++ )
			temp.add( new Deplacement ( arg ) );
		
		return temp;
		
	}

}
