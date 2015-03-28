/**
 * 
 */
package projet;

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
	}
	
	@Override
	public String toString() {
		return "( D" + numDrapeau + ")"; 
	}

}
