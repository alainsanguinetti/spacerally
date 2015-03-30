package cartes;

import java.util.LinkedList;


/**
 * Describes the cards that performs a rotation of the robot
 * @author alain
 *
 */
public class Orientation extends Carte {
	
	/**
	 * The angle of the rotation 
	 *    ** 90 is 90° counter-clockwise,
	 *    ** -90 is 90° clockwise
	 *    ** 180 is 180°
	 */

	/*
	 *           *** Constructor ***
	 */
	public Orientation( int angle ) {
		
		setParam ( angle );
		
	}
	
	/*
	 *           *** Fonctions ***
	 */
	public static LinkedList<Carte> cartes ( int nb, int arg ) {
		
		LinkedList<Carte> temp = new LinkedList<Carte>();
		
		for ( int i = 0; i < nb; i++ )
			temp.add( new Orientation ( arg ) );
		
		return temp;
		
	}

}
