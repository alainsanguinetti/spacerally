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
	/*
	 * ATTRIBUTS
	 */
	/**
	 * Chaque case a une position de la forme (X,Y) qui indique l'endroit ou la case
	 * sera placee dans le plateau. Une position (0,0) indique que la case sera placee dans
	 * l'intersection de la premiere ligne et la premiere colonne.
	 */
	private Position p;
	/**
	 * Chaque case a une image associee pour son afficchage graphique. Les objects Case et Puits
	 * ont tous la meme image. Chaque object Drapeau a une image different. Pour les objects Robot, on
	 * a deux robots differents, et chacun a 4 images differents (une pour chaque orientation).
	 */
	protected Image img;
	
	/*
	 * CONSTRUCTEUR
	 */
	/**
	 * Chaque fois qu'on souhaite creer une nouvelle case il faut le donner
	 * une position (laquelle peut etre change apres). Au meme temps quand on cree
	 * une Case on le donne une image.
	 * @param pos, position initialle de la case.
	 */
	public Case (Position pos) {
		p = pos;
		try {
			this.img = ImageIO.read(new File("img/cases/case.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * SETTERS/GETTERS
	 */
	/**
	 * On obtient la position de la case.
	 * @return la position de la case.
	 */
	public Position getPosition() {
		return this.p;
	}
	/**
	 * On modifie la position de la Case de forme (x,y).
	 * @param x, position horizontale.
	 * @param y, position verticale.
	 */
	public void setPosition(int x, int y) {
		this.p.setPos(x, y);
	}
	/**
	 * On obtient l'image associee a la Case.
	 * @return l'image de la Case.
	 */
	public Image getImage() {
		return this.img;
	}
	/*
	 * METHODES
	 */
	/**
	 * On associe un String a la Case pour un affichage en terminal.
	 */
	@Override
	public String toString () {
		return "(   )";
	}

}
