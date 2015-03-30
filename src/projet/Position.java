/**
 * 
 */
package projet;

/**
 * @author eder
 *
 */
public class Position {

	/*
	 * 		ATTRIBUTS
	 */
	/**
	 * Position horizontale de la case.
	 */
	private int x;
	/**
	 * Position verticale de la case.
	 */
	private int y;
	
	/*
	 * 		CONSTRUCTEUR
	 */
	/**
	 * Chaque fois qu'on cree une Position il faut le donner les valeurs X et Y pour obtenir la position (X,Y).
	 */
	public Position(int i, int j) {
		x = i;
		y = j;
	}
	
	/*
	 * 		GETTERS/SETTERS
	 */
	/**
	 * On obtient la position X
	 * @return X
	 */
	public int getX () {
		return this.x;
	}
	/**
	 * On obtient la position Y
	 * @return Y
	 */
	public int getY () {
		return this.y;
	}
	/**
	 * On modifie la position X
	 * @param v, nouvelle position X
	 */
	public void setX (int v) {
		this.x = v;
	}
	/**
	 * On modifie la position Y
	 * @param v, nouvelle position Y
	 */
	public void setY (int v) {
		this.y = v;
	}
	
	/*
	 * 		METHODES
	 */
	/**
	 * On modifie la position globalement, sans acceder individuellement a chaque parametre.
	 * @param u, position X
	 * @param v, position Y
	 */
	public void setPos (int u, int v) {
		this.x = u;
		this.y = v;
	}
	/**
	 * Fonction pour associer la position a un String et l'afficher dans un terminal.
	 */
	public String toString () {
		return "(" + this.x + "," + this.y + ")";
	}
}
