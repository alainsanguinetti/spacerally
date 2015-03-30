package cartes;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

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
		try {
			switch(distance) {
			case 1: this.img = ImageIO.read(new File("img/cartes/avance1.png"));
					break;
			case 2: this.img = ImageIO.read(new File("img/cartes/avance2.png"));
					break;
			case 3: this.img = ImageIO.read(new File("img/cartes/avance3.png"));
					break;
			case -1: this.img = ImageIO.read(new File("img/cartes/rec.png"));
					 break;
			default: break;
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
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
