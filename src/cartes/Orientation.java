package cartes;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;


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
		try {
			switch(angle) {
			case 90: this.img = ImageIO.read(new File("img/cartes/right.png"));
					break;
			case -90: this.img = ImageIO.read(new File("img/cartes/left.png"));
					break;
			case 180: this.img = ImageIO.read(new File("img/cartes/demitour.png"));
					break;
			default: break;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
