/**
 * 
 */
package projet;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author eder
 *
 */
public class Case {
	
	private Position p;
	protected Image img;
	
	public Case (Position pos) {
		p = pos;
		try {
			this.img = ImageIO.read(new File("img/cases/case.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public void setPosition(int x, int y) {
		this.p.setPos(x, y);
	}
	
	public Image getImage() {
		return this.img;
	}
	
	@Override
	public String toString () {
		return "(   )";
	}

}
