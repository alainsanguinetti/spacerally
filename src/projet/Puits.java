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

	/**
	 * 
	 */
	public Puits(Position pos) {
		super(pos);
		try {
			this.img = ImageIO.read(new File("img/cases/case_puit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "( X )";
	}

}
