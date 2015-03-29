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
	 * ATTRIBUTS
	 */
	private int x;
	private int y;
	
	/**
	 * 
	 */
	public Position(int i, int j) {
		x = i;
		y = j;
	}
	
	/*
	 * GET/SET
	 */
	
	public int getX () {
		return this.x;
	}
	
	public int getY () {
		return this.y;
	}
	
	public void setX (int v) {
		this.x = v;
	}
	
	public void setY (int v) {
		this.y = v;
	}
	
	/*
	 * METHODES
	 */
	
	public void setPos (int u, int v) {
		this.x = u;
		this.y = v;
	}
	
	public String toString () {
		return "(" + this.x + "," + this.y + ")";
	}
}
