/**
 * 
 */
package projet;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author eder
 *
 */
public class Puits extends Case {
	/*
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Chaque fois qu'on cree un objet Puits on l'attribue un image.
	 * @param pos, position initiale
	 */
	public Puits(Position pos) {
		super(pos);
		try {
			this.img = ImageIO.read(new File("img/cases/case_puit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 		METHODES
	 */
	/**
	 * On associe un String a Puits pour un affichage en terminal.
	 */
	public String toString() {
		return "( X )";
	}

}
