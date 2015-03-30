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
public class Drapeau extends Case {
	
	/*
	 * 		ATTRIBUTS
	 */
	/**
	 * Chaque drapeau a un numero associe, ce numero va de 1 a 4. A part d'intifier un drapeau,
	 * le numero represent l'ordre dans lesquel les jouers doivent les collecter.
	 */
	private int numDrapeau;
	/**
	 * On utilise un counter pour gerer l'assigantion de numero de drapeau chaque fois que le constructeur
	 * est appele. La valeur initiale est 1 car la premier fois qu'on appel le constructeur on va creer le drapeau
	 * numero 1.
	 */
	private static int counter=1;
	
	/*
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Il faut donner une position initiale. Au meme temps on l'assigne un numero de drapeau selon la variable counter.
	 * On augmente counter pour la prochaine fois qu'il est utilise. Selon le numero de drapeau on attribue une image a
	 * l'object Drapeau.
	 * @param pos, position initiale
	 */
	public Drapeau(Position pos) {
		super(pos);
		numDrapeau = counter;
		counter++;
		try {
			switch(numDrapeau) {
			case 1: this.img = ImageIO.read(new File("img/cases/case_d1.png"));
					break;
			case 2: this.img = ImageIO.read(new File("img/cases/case_d2.png"));
					break;
			case 3: this.img = ImageIO.read(new File("img/cases/case_d3.png"));
					break;
			case 4: this.img = ImageIO.read(new File("img/cases/case_d4.png"));
					break;
			default: break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 		METHODES
	 */
	/**
	 * On associe un String au Drapeau pour un affichage en terminal.
	 */
	@Override
	public String toString() {
		return "( D" + numDrapeau + ")"; 
	}

}
