/**
 * 
 */
package projet;

/**
 * @author eder
 *
 */
public class Case {
	
	private Position p;
	
	public Case (Position pos) {
		p = pos;
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public void setPosition(int x, int y) {
		this.p.setPos(x, y);
	}
	
	@Override
	public String toString () {
		return "(   )";
	}

}
