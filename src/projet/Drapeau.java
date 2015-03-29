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
	private int numDrapeau;
	private static int counter=1;

	/**
	 * 
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
	
	@Override
	public String toString() {
		return "( D" + numDrapeau + ")"; 
	}

}
